"use client"

import Ranking from "@/components/Ranking/ranking"
import Podium from "@/components/Ranking/podium"



export default function Home() {
    return (
    <main className="p-5 h-full w-full justify-between flex">
        <Podium />
        <Ranking />
    </main>
  );
}


