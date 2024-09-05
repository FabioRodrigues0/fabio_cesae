import * as React from 'react'
import db from "@/lib/db";
import {Card, CardContent, CardDescription, CardHeader, CardTitle} from "@/components/ui/card";
import {Table, TableBody, TableCell, TableHead, TableHeader, TableRow} from "@/components/ui/table";
import {Button} from "@/components/ui/button";
import Link from "next/link";

export default async function RepoNamePage({params: {name},}: { params: { name: string } }) {
    const repo = await db.repos.findFirstOrThrow({
        where: {name},
        select: {
            name: true,
            url: true,
            designNote: true,
            codeNote: true,
            lines: true,
            contributors: {
                select: {
                    contribution: true,
                    contributorName: true,
                    points: true,
                    editLines: true,
                    deletedLines: true,
                },
                orderBy: {
                    contribution: 'desc',
                }
            },
        },
    })

    return (
        <Card className="w-1/2">
            <CardHeader>
                <CardTitle className="text-4xl">{
                    repo.name}
                    <Link href={"/repos/"+repo.name+"/edit"}><Button type="button" className="float-end">Edit</Button></Link>
                </CardTitle>
                <CardDescription></CardDescription>
            </CardHeader>
            <CardContent>
                <p>{(repo.designNote) ? repo.designNote : " "}</p>
                <p>{(repo.codeNote) ? repo.codeNote : " "}</p>
                <p><a
                    href={"https://www.codefactor.io/repository/github/" + repo.url}><img
                    src={"https://www.codefactor.io/repository/github/" + repo.url + "/badge/main"}
                    alt="CodeFactor"/></a></p>
                <p>{"Lines of Code: " + repo.lines}</p>
                <br/>
                <Link href={"https://github.com/" + repo.url} target="_blank">
                    <Button type="button">Repository</Button>
                </Link>
                <Table className="mt-5 w-full">
                    <TableHeader>
                        <TableRow>
                            <TableHead className="w-1/2">Name</TableHead>
                            <TableHead>Edit Lines</TableHead>
                            <TableHead>Deleted Lines</TableHead>
                            <TableHead className="text-right">Points</TableHead>
                            <TableHead className="text-right">Contribution</TableHead>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        {repo.contributors.map((contributor) => (
                            <TableRow key={contributor.contributorName}>
                                <TableCell className="font-medium">{contributor.contributorName}</TableCell>
                                <TableCell>{contributor.editLines}</TableCell>
                                <TableCell>{contributor.deletedLines}</TableCell>
                                <TableCell className="text-right">{contributor.points?.toString()}</TableCell>
                                <TableCell className="text-right">
                                    {((100 * (contributor.editLines-contributor.deletedLines)) / repo.lines).toFixed(2)}%
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </CardContent>
        </Card>
    )
}