package ru.phantom2097.troikaapp.domain.use_cases

import ru.phantom2097.troikaapp.domain.repository.MetroRepository

class GetSubscriptionsInfoUseCase(
    val repository: MetroRepository
) {
    operator fun invoke() {  }

}