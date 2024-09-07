package com.jessica.semeqteste.screen

internal enum class Route {
    LOGIN,
    HOME;

    companion object {
        fun getValue(route: String) = Route.entries.firstOrNull { it.name == route }
    }
}