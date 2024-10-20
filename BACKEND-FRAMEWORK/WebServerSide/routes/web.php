<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', function () {
    return view('utils.home');
})->name('homepage');

Route::get('/hello_world/{name}', function ($name) {
    return '<h1>Hello ' . $name . '</h1>';
});

// -------- USERS ROUTES ---------
Route::get('/users', function () {
    return view('users.all_users');
})->name('users.all');

Route::get('/users/add', function () {
    return view('users.add_user');
})->name('users.add');

// -------- FALLBACK ROUTES ---------
Route::fallback(function () {
    return view('utils.fallback');
})->name('utils.fallback');
