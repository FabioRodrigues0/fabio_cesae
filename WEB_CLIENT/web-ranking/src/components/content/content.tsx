import * as React from 'react'
import {ReactNode} from "react";

export default function Content({children}: { children: ReactNode }) {
    return (
        <div className="p-2 w-[90%]">
            {children}
        </div>
    )
}