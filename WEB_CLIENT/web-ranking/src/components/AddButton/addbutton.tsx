import * as React from 'react'
import {Plus} from "lucide-react";
import {Button} from "@/components/ui/button";

import Link from "next/link";

export default function AddButton() {

    return (
        <div className="absolute bottom-10 right-10">
            <Button asChild className="border-2 rounded-full w-20 h-20 p-4">
                <Link href="/repos/new">
                    <Plus type="button" className="text-background " />
                    <span className="sr-only">Add New Repository</span>
                </Link>
            </Button>
        </div>

    )
}