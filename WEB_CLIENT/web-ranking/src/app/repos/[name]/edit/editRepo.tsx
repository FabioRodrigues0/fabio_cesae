"use client"

import * as React from 'react'
import {Input} from "@/components/ui/input";
import {Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle} from "@/components/ui/card";
import {EditSelect} from "@/app/repos/[name]/edit/_components/editSelect";
import {Label} from "@/components/ui/label";
import {Button} from "@/components/ui/button";
import {updateRepos} from "@/app/_actions/repos";

export default function EditRepo(props: any) {
    const repo = props.repo
    const arrayNotes = Array.from({length: 10}, (v, k) => k + 1);
    const objNotes = arrayNotes.reduce((o, key) => ({ ...o, [key]: key}), {})
    const [design, setDesign] = React.useState(" ");
    const [code, setCode] = React.useState(" ");
    const [course, setCourse] = React.useState("");
    async function onSubmitUpdateRepo() {
        await updateRepos(repo.name, parseInt(design), parseInt(code), course)
    }
    return (
        <form onSubmit={onSubmitUpdateRepo}>
            <Card className="w-1/2 my-2">
                <CardHeader>
                    <CardTitle className="text-4xl">
                        {repo.name}
                    </CardTitle>
                    <CardDescription></CardDescription>
                </CardHeader>
                <CardContent>
                    <EditSelect label="designNote"
                                place="Select a Note"
                                items={objNotes}
                                change={setDesign}
                                value={design}/>
                    <EditSelect label="codeNote"
                                place="Select a Note"
                                items={objNotes}
                                change={setCode}
                                value={code}/>
                    <Label>Insert Course</Label>
                    <Input id="course" onChange={e => setCourse(e.target.value)} placeholder="Insert Course"></Input>
                </CardContent>
                <CardFooter>
                    <Button type="submit" className="float-end">Submit</Button>
                </CardFooter>
            </Card>
        </form>
    )
}