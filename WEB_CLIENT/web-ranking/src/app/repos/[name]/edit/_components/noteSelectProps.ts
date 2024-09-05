type NoteSelectProps = {
    label: string,
    value?: string,
    place: string,
    items: any,
    change?: (value: (((prevState: string) => string) | string)) => void
}