"use server"

import db from "@/lib/db"

// function for getting a list of Contributors
export async function getContributorsName() {
    const contributors = await db.contributor.findMany({select: {name: true,}});
    return contributors.map((c: { name: string }) => [c.name])
}

export async function updateContributors(nameOld: string, nameNew: string) {
    const contributorsOld = await db.contributorRepos.findFirstOrThrow({
        where: { contributorName: nameOld },
        select: {
            editLines: true,
            deletedLines: true,
            contribution: true,
        } })
    const contributorsNew = await db.contributorRepos.findFirstOrThrow({
        where: { contributorName: nameNew },
        select: {
            editLines: true,
            deletedLines: true,
            contribution: true,
        } })

    await db.contributorRepos.updateMany({
        where: { contributorName: nameNew },
        data: {
            editLines: contributorsOld.editLines + contributorsNew.editLines,
            deletedLines: contributorsOld.deletedLines + contributorsNew.deletedLines,
            contribution: contributorsOld.contribution + contributorsNew.contribution,
        },
    })

    await db.contributorRepos.deleteMany({
        where: {
            contributorName: nameOld,
        },
    })
}