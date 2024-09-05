"use server"

import db from "@/lib/db"
import {notFound, redirect} from "next/navigation"
import {revalidatePath} from "next/cache"

/**
 * Receive repoName for search on database that Repository with that name
 *
 * @param repoName
 */
export async function getRepos(repoName: string){
    const repoTemp = await db.repos.findFirstOrThrow({
        where: {name: repoName},
        select: {
            name: true,
            url: true,
            designNote: true,
            codeNote: true,
            lines: true,
            contributors: {
                select: {
                    contributorName: true,
                    points: true,
                    editLines: true,
                    deletedLines: true,
                }
            },
        }
    });
    console.log()
    return repoTemp
}

/**
 * Receive urlRepo for Fetch api with that
 *
 * @param urlRepo
 */
export async function addRepos(urlRepo: string): Promise<void> {
    const response = await fetch(`https://api.github.com/repos/${urlRepo}/stats/contributors`)
            .then(res => { return res.json()})
            .catch(err => {console.log(err)});

    /*const con = await response.json();*/
    const lineCounts = response.map((contributor: { weeks: any[]}) => {
        return (
            contributor.weeks.reduce((lineCount: Number, week: any) => lineCount + week.a - week.d, 0)
        );
    });
    const lines: number = lineCounts.reduce((lineTotal: any, lineCount: any) => lineTotal + lineCount);

    let login: Array<string> = [];
    const result = response.map((data: { weeks: any[]; author: { login: any, avatar_url: string } }) => {

        const totalA = data.weeks.reduce((acc, week) => acc + week.a, 0);
        const totalD = data.weeks.reduce((acc, week) => acc + week.d, 0);

        login.push(data.author.login);

        return {
            contribution: parseFloat(((100 * (totalA-totalD)) / lines).toFixed(2)),
            editLines: totalA,
            deletedLines: totalD,
            contributorName: data.author.login,
            avatar_url: data.author.avatar_url
        };
    });

    const newRepo: {
        contributor: any;
        name: string;
        lines: number; 
        url: string
    } = {
        name: urlRepo?.split("/")[1],
        url: urlRepo,
        lines: lines,
        contributor: result,
    }

    for (const login1 of login) {
        try {
            await db.contributor.findFirstOrThrow({
                where: { name: login1 }
            })
        }catch(error) {
            await db.contributor.create({
                data: {
                    name: login1,
                },
            })
        }
    }

    await db.repos.create({
        data: {
            name: newRepo.name,
            url: newRepo.url,
            lines: newRepo.lines,
            contributors: {
                create: newRepo.contributor
            }
        },
    })

    revalidatePath("/")
    revalidatePath("/repos")
    redirect("/repos")
}

export async function updateRepos(name: string, design: number, code: number, course: string) {

    const repo = await db.repos.findUnique({ where: {name: name } })

    if (repo == null) return notFound()

    await db.repos.updateMany({
        where: { name: name },
        data: {
            designNote: design,
            codeNote: code,
            course: course
        },
    })
    const contributorsOnRepo = await db.contributorRepos.findMany({
        where: { repoName: name },
        select: {
            contribution: true,
            contributor:{
                select: {
                    name: true
                }
            }
        } })

    const contributorsAndPoints = contributorsOnRepo.map((data: { contribution: number; contributor: { name: string } }) => {
        return {
            name: data.contributor.name,
            points: (data.contribution*(design+code)/100).toFixed(2)
        }
    });

    for (const contributors of contributorsAndPoints) {
            await db.contributorRepos.updateMany({
                where: {contributorName: contributors.name},
                data: {
                    points: parseFloat(contributors.points),
                },
            })
        }

    revalidatePath("/")
    revalidatePath("/repos")

    redirect("/repos")
}



