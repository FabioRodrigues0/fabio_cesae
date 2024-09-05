import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import { cn } from "@/lib/utils"
import {NavBar, NavBarLink, SideBar} from "@/components/Navbar/navbar";
import React from "react";
import AddButton from "@/components/AddButton/addbutton";
import Content from "@/components/content/content";
import {Folder, Home, User} from "lucide-react";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Ranking Course",
  description: "Ranking to see who work more",
};

export default function RootLayout({
  children
}: Readonly<{
  children: React.ReactNode
}>) {
  return (
    <html lang="en">
    <body className={cn("min-h-screen bg-background font-sans antialiased", inter.className)}>
        <div className="">
            <NavBar>
                <NavBarLink href="/">Home</NavBarLink>
                <NavBarLink href="/repos">Repositories</NavBarLink>
                <NavBarLink href="/contributor">Contributor</NavBarLink>
            </NavBar>
            <div className="flex flex-row w-screen max-h-screen gap-2">
                <SideBar>
                    <NavBarLink href="/"><Home className="h-4 w-4 me-2"/>Home</NavBarLink>
                    <NavBarLink href="/repos"><Folder className="h-4 w-4 me-2"/>Repositories</NavBarLink>
                    <NavBarLink href="/contributor"><User className="h-4 w-4 me-2"/>Contributor</NavBarLink>
                </SideBar>
                <Content>
                    {children}
                </Content>
            </div>
            <AddButton/>
        </div>
    </body>
    </html>
);
}
