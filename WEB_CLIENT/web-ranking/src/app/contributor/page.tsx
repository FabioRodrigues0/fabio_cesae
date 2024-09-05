"use client"

import * as React from 'react'
import db from "@/lib/db";

async function getContributor(contributorName: string) {
    return db.contributor.findFirstOrThrow({
        where: {
            name: contributorName,
        }
    })
}

export default function Contributor() {
    return (
        <div><h1>Test Contributor</h1></div>
    )
}