package ru.phantom2097.troikaapp.domain.models

import ru.phantom2097.troikaapp.domain.entites.MetroStation

data class MetroStationImpl(
    override val stationName: String,
    override val lineNum: Int,
    override val lineColor: Int,
    override val lineName: Int,
    override val isOpen: Boolean
) : MetroStation