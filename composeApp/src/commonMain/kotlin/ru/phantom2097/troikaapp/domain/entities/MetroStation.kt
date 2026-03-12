package ru.phantom2097.troikaapp.domain.entities

interface MetroStation {
    val stationName: String
    val lineNum: Int
    val lineColor: Int
    val lineName: String
    val isOpen: Boolean
}