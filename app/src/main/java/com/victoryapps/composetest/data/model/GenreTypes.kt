package com.victoryapps.composetest.data.model

/**
 * Enum to map genre ids to local image resources
 */
enum class GenreTypes(val id: Int, val drawable: String) {
    Action(1, "action_thumbnail"),
    Comedy(2, "comedy_thumbnail"),
    Drama(3, "drama_thumbnail"),
    SciFi(4, "scifi_thumbnail");

    companion object {
        fun fromId(id: Int) = GenreTypes.values().firstOrNull { it.id == id } ?: Action
    }
}