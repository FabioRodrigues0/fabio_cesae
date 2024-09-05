"use client"

import * as React from 'react'
import {Card, CardContent, CardFooter} from "@/components/ui/card";
import {EditSelect} from "@/app/repos/[name]/edit/_components/editSelect";
import {Button} from "@/components/ui/button";
import {updateContributors} from "@/app/_actions/contributors";

export default function EditContributors(props: any) {
    const contributors = props.contributors
    const [contributorsOld, setContributorsOld] = React.useState("old");
    const [contributorsNew, setContributorsNew] = React.useState("new");
    async function onSubmitUpdateContributors() {
        await updateContributors(contributorsOld, contributorsNew)
    }
    return (
        <form onSubmit={onSubmitUpdateContributors}>
            <Card className="w-1/2 my-2">
                <CardContent className="mt-5">
                    <EditSelect label="from"
                                place="Select a Contributors"
                                change={setContributorsOld}
                                items={contributors}/>
                    <EditSelect label="to"
                                place="Select a Contributors"
                                change={setContributorsNew}
                                items={contributors}/>
                </CardContent>
                <CardFooter>
                    <Button type="submit" className="float-end">Submit</Button>
                </CardFooter>
            </Card>
        </form>
    )
}