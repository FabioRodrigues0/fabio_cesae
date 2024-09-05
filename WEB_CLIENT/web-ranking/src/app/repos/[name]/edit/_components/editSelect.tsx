import * as React from 'react'
import {Label} from "@/components/ui/label";
import {Select, SelectContent, SelectItem, SelectTrigger, SelectValue} from "@/components/ui/select";

export function EditSelect({label, value, place, items, change}: NoteSelectProps){
    const a_values = Object.values(items);
    return (
        <div className="grid gap-3 my-2">
            <Label htmlFor="labelField">{label}</Label>
            <Select defaultValue={value ? `${value}` : ""} onValueChange={change}>
                <SelectTrigger>
                    <SelectValue placeholder={place}/>
                </SelectTrigger>
                <SelectContent id={label} >
                    {a_values.map((_: any, i: any) =>
                        <SelectItem key={i} value={_+""}>{_}</SelectItem>
                    )}
                </SelectContent>
            </Select>
        </div>
    )
}