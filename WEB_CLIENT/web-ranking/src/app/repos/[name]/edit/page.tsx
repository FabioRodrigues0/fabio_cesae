"use server"

import * as React from 'react'
import {getRepos} from "@/app/_actions/repos";
import EditRepo from "@/app/repos/[name]/edit/editRepo";
import {getContributorsName} from "@/app/_actions/contributors";
import EditContributors from "@/app/repos/[name]/edit/editContributors";


export default async function ReposNamePageEdit({params: {name},}: { params: { name: string } }) {
    const repo = await getRepos(name)
    const contributors = await getContributorsName()

    return (
        <>
            <EditRepo repo={repo}/>
            <EditContributors contributors={contributors}/>
        </>
    )
}

