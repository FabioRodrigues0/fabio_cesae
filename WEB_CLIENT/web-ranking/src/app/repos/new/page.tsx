"use client"

import * as React from 'react'
import {Skeleton} from "@/components/ui/skeleton";
import {
    AlertDialog,
    AlertDialogContent,
    AlertDialogDescription,
    AlertDialogFooter,
    AlertDialogHeader,
    AlertDialogTitle,
    AlertDialogTrigger,
} from "@/components/ui/alert-dialog"
import {FormEvent, useState} from "react";
import { Label } from '@/components/ui/label';
import { Input } from '@/components/ui/input';
import {addRepos} from "@/app/_actions/repos";
import {Button} from "@/components/ui/button";

export default function NewRepoPage() {
    const [show, setShow] = useState(true);
    const [repoLink, setRepoLink] = useState()
    async function onSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault()

        const formData = new FormData(event.currentTarget)
        setShow(false)
        let result = await addRepos(`${formData.get("link")}`)
    }

    return (
        <div>
            <div className="flex space-y-3">
                <Skeleton className="h-[125px] w-[250px] rounded-xl"/>
                <div className="ms-2 space-y-2">
                    <Skeleton className="h-6 w-[250px]"/>
                    <Skeleton className="h-6 w-[200px]"/>
                    <Skeleton className="h-6 w-[100px]"/>
                </div>
            </div>
            <AlertDialog open={show}>
                <AlertDialogTrigger></AlertDialogTrigger>
                <AlertDialogContent>
                    <AlertDialogHeader>
                        <AlertDialogTitle>Add new Repository</AlertDialogTitle>
                        <AlertDialogDescription>

                        </AlertDialogDescription>
                    </AlertDialogHeader>
                    <form onSubmit={onSubmit}>
                        <Label htmlFor="link">Url</Label>
                        <Input
                            type="text"
                            id="link"
                            name="link"
                            required
                            value={repoLink}
                        />
                        <Button type="submit">Add</Button>
                    </form>

                    <AlertDialogFooter>
                    </AlertDialogFooter>
                </AlertDialogContent>
            </AlertDialog>
        </div>

    )
}