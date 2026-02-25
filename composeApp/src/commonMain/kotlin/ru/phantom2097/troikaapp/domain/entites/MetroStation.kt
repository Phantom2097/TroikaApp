package ru.phantom2097.troikaapp.domain.entites

interface MetroStation {
    val stationName: String
    val lineNum: Int
    val lineColor: Int
    val lineName: String
    val isOpen: Boolean
}