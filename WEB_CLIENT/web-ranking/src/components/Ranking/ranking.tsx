import * as React from 'react'
import {Card, CardContent, CardHeader, CardTitle} from "@/components/ui/card";
import {Table, TableHeader, TableRow, TableHead, TableBody, TableCell} from "@/components/ui/table";
import db from "@/lib/db";
import {Button} from "@/components/ui/button";
import NoDataDB from "@/components/Ranking/NoDataDB";

function getRankingData() {
    return db.contributorRepos.findMany({
        select: {
            contributorName: true,
            points: true,
        },
        orderBy: {
            points: "desc"
        }
    });
}

export default function Ranking()  {
    return (
        <RankingTable />
    )
}

async function RankingTable(){
    const listReposTemp = await getRankingData()

    if (listReposTemp.length === 0) return <NoDataDB title="Ranking Table" description="Don't have Contributors"/>
    return (
        <Card className="sm:w-1/2 w-full">
            <CardHeader>
                <CardTitle>Ranking</CardTitle>
            </CardHeader>
            <CardContent>
                <Table>
                    <TableHeader>
                        <TableRow>
                            <TableHead className="w-1/2">Name</TableHead>
                            <TableHead className="text-right">Points</TableHead>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        {listReposTemp.map((repo) => (
                            <TableRow key={repo.contributorName}>
                                <TableCell className="font-medium">{repo.contributorName}</TableCell>
                                <TableCell className="text-right">{repo.points?.toString()}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </CardContent>
        </Card>
    )
}

function NoReposDB(){
    return (
        <main className="flex flex-1 flex-col gap-4 p-4 lg:gap-6 lg:p-6">
            <div className="flex items-center">
                <h1 className="text-lg font-semibold md:text-2xl">Ranking Table</h1>
            </div>
            <div
                className="flex flex-1 items-center justify-center rounded-lg border border-dashed shadow-sm min-h-screen min-w-fit"
                x-chunk="dashboard-02-chunk-1"
            >
                <div className="flex flex-col items-center gap-1 text-center">
                    <h3 className="text-2xl font-bold tracking-tight">
                        You have no Repositories
                    </h3>
                </div>
            </div>
        </main>
    )
}