package ru.phantom2097.troikaapp.domain.models

import ru.phantom2097.troikaapp.domain.entities.MetroStation

data class MetroStationImpl(
    override val stationName: String,
    override val lineNum: Int,
    override val lineColor: Int,
    override val lineName: String,
    override val isOpen: Boolean
) : MetroStation