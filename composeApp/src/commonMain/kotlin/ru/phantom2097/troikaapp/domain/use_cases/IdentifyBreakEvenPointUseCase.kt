package ru.phantom2097.troikaapp.domain.use_cases

import ru.phantom2097.troikaapp.domain.repository.MetroRepository

// Расчёт количества поездок, которые нужно совершить, чтобы абонемент был выгодным
class IdentifyBreakEvenPointUseCase(
    val repository: MetroRepository
) {
    operator fun invoke() {  }

}