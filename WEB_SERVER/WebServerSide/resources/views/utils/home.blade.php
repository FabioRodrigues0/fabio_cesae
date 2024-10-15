@extends('layouts.femaster')
@section('content')
    <main class="mt-6">
        <div class="bg-white p-5">
            <h1>Home</h1>
            <a href="{{ route('users.add') }}">
                <button>Add User</button>
            </a>
        </div>
    </main>
@endsection


