@extends('layouts.index')
@section('header')
    <div class="grid h-1/4 w-full md:grid-cols-[220px_1fr] lg:grid-cols-[280px_1fr]">
        <div class="hidden md:block bg-primary h-14 border-b px-4 lg:h-[60px] lg:px-6">
            <a href="/" class="flex text-background items-center gap-2 font-semibold">
                <span class="">Users</span>
            </a>
        </div>
        <div class="flex flex-col">
            <header class="flex bg-primary h-14 items-center gap-4 border-b px-4 lg:h-[60px] lg:px-6">
                <nav class="grid gap-2 text-lg font-medium">
                    <a href="/"> Welcome</a>
                    <a href="{{ route('homepage') }}"> Home</a>
                    <a href="{{ route('users.all') }}">Users</a>
                </nav>
            </header>
        </div>
    </div>
@endsection
