"use client"

import React, {Suspense} from 'react';
import { Avatar, AvatarFallback } from "@/components/ui/avatar";

export function AvatarRanking(props: {src: string, alt: string, fallbackText: string}) {
    const src = props.src;
    const alt = props.alt;
    const fallbackText = props.fallbackText;
    return (
        <div className="relative flex w-[150px] h-[150px] mb-2 mx-6 shrink-0 overflow-hidden rounded-full">
            <Suspense fallback={<AvatarFall fallbackText={fallbackText}/>}>
                <img src={src} alt={alt}/>
            </Suspense>
        </div>
    );
}

const AvatarFall = (props: { fallbackText: string }) => {
    const fallbackText = props.fallbackText;
    return (
        <Avatar>
            <AvatarFallback>{fallbackText}</AvatarFallback>
        </Avatar>
    );
};
