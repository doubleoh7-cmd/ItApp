package com.example.itapp

interface NavigationHost {
    fun navigateTo(activity: MainActivity, addToBackstack: Boolean)
}
