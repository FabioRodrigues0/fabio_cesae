"use client"

import * as React from "react"
import Link from "next/link"
import {ComponentProps, ReactNode} from "react";
import {usePathname} from "next/navigation";
import {cn} from "@/lib/utils";
import {
    DropdownMenu,
    DropdownMenuContent, DropdownMenuItem,
    DropdownMenuLabel,
    DropdownMenuSeparator,
    DropdownMenuTrigger
} from "@/components/ui/dropdown-menu";
import {Button} from "@/components/ui/button";
import {ChartLineIcon, CircleUser, Menu} from "lucide-react";
import {Sheet, SheetContent, SheetTrigger} from "@/components/ui/sheet";

export function NavBar({children}: { children: ReactNode }) {
    return (
        <div className="grid h-1/4 w-full md:grid-cols-[220px_1fr] lg:grid-cols-[280px_1fr]">
            <div className="hidden md:block bg-primary h-14 border-b px-4 lg:h-[60px] lg:px-6">
                <Link href="/" className="flex text-background items-center gap-2 font-semibold">
                    <ChartLineIcon className="h-6 w-6 m-5"/>
                    <span className="">Ranking Course</span>
                </Link>
            </div>
            <div className="flex flex-col">
                <header className="flex bg-primary h-14 items-center gap-4 border-b px-4 lg:h-[60px] lg:px-6">
                        <Sheet>
                            <SheetTrigger asChild>
                                <Button variant="outline" size="icon" className="shrink-0 md:hidden">
                                    <Menu className="h-5 w-5"/>
                                    <span className="sr-only">Toggle navigation menu</span>
                                </Button>
                            </SheetTrigger>
                            <SheetContent side="left" className="flex flex-col">
                                <nav className="grid gap-2 text-lg font-medium">
                                    {children}
                                </nav>
                            </SheetContent>
                        </Sheet>
                </header>
            </div>
        </div>
)
}

export function SideBar({children}: { children: ReactNode }) {
    return (
        <div className="flex-1 bg-muted/40 xl:w-[10%] h-[93vh] border-r sm:block p-0 hidden">
            <nav className="grid items-start text-sm font-medium">
                {children}
            </nav>
        </div>
    )
}


export function NavBarLink(props: Omit<ComponentProps<typeof Link>, "className">) {
    const pathname = usePathname()
    return <Link {...props} className={cn("p-4 flex " +
        "hover:bg-secondary hover:text-secondary-foreground" +
        "\"focus-visible:bg-secondary focus-visible:text-secondary-foreground",
        pathname === props.href && "bg-background text-foreground font-bold")}/>
}

export function NavBarBadge(props: Omit<ComponentProps<typeof DropdownMenu>, "className">) {
    return <DropdownMenu>
        <DropdownMenuTrigger asChild>
            <Button variant="secondary" size="icon" className="rounded-full">
                <CircleUser className="h-5 w-5"/>
                <span className="sr-only">Toggle user menu</span>
            </Button>
        </DropdownMenuTrigger>
        <DropdownMenuContent align="end">
            <DropdownMenuLabel>My Account</DropdownMenuLabel>
            <DropdownMenuSeparator/>
            <DropdownMenuItem>Settings</DropdownMenuItem>
            <DropdownMenuItem>Support</DropdownMenuItem>
            <DropdownMenuSeparator/>
            <DropdownMenuItem>Logout</DropdownMenuItem>
        </DropdownMenuContent>
    </DropdownMenu>
}
