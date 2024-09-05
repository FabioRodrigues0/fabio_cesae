"use server"

import * as React from 'react'
import db from "@/lib/db";
import {Card, CardContent, CardDescription, CardHeader, CardTitle} from "@/components/ui/card";
import Link from "next/link";

export default async function ReposPage() {
    const reposData = await db.repos.findMany({
        select: {
            name: true,
            url: true,
        }
    })
    return (
        <div className="m-4 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 xl:grid-cols-5 gap-4">
            {reposData.map((repo, key) => (
                <ReposCard key={key} name={repo.name} url={repo.url ? repo.url : ""} course={""}/>
                ))}
        </div>
    )}

type ReposCardProps = {
    name: string
    url: string
    course: string
}

function ReposCard({ name, url, course }: ReposCardProps) {
    return (
        <Link href={"/repos/"+name}>
            <Card>
                <CardHeader>
                    <CardTitle className="text-2xl">{name}</CardTitle>
                    <CardDescription>{course}</CardDescription>
                </CardHeader>
                <CardContent>
                    <p>{url}</p>
                </CardContent>
            </Card>
        </Link>
    )
}