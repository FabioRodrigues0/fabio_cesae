import * as React from 'react'
import db from "@/lib/db";
import NoDataDB from "@/components/Ranking/NoDataDB";
import {AvatarRanking} from "@/components/Ranking/AvatarRanking";

function getPodiumData() {
    return db.contributorRepos.findMany({
        take: 3,
        select: {
            avatar_url: true,
            contributorName: true,
            points: true,
        },
        orderBy: {
            points: "desc"
        }
    });
}

export default function Podium()  {
    return (
        <PodiumCards />
    )
}

async function PodiumCards(){
    const listReposTemp = await getPodiumData()
    const podiums = [
        {
            color: "bg-amber-200",
            size: "podium_1",
            position: "top_1",
        },
        {
            color: "bg-amber-100",
            size: "podium_2",
            position: "top_2",
        },
        {
            color: "bg-amber-50",
            size: "podium_3",
            position: "top_3",
        }
    ]


    if (listReposTemp.length === 0) return <NoDataDB title="Podium" description="Don't have Contributors"/>
    return (
        <div className="sm:w-1/2 flex-col columns-3 podium">

            {/*<AvatarCom src="https://github.com/shadcn.png" alt="@marklyck" fallbackText="ML" />*/}

            {listReposTemp.map((repo, index) => (
                <div key={index} className={"p-10 h-full text-center content-end "+podiums[index].position}>
                    <AvatarRanking src={repo.avatar_url} alt={repo.contributorName} fallbackText={repo.contributorName.slice(0, 2)} />
                    <div className={podiums[index].color+" rounded-2xl w-full flex-wrap "+ podiums[index].size}>
                        <span className="sr-only">Rank {(index+1)}</span>
                    </div>
                </div>
            ))}
        </div>
    )
}