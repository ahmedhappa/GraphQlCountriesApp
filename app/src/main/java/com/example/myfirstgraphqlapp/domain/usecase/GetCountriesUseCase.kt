package com.example.myfirstgraphqlapp.domain.usecase

import com.example.myfirstgraphqlapp.domain.remote.CountryClient
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryClient: CountryClient
) {
    suspend operator fun invoke() = countryClient.getCountries().sortedBy { it.name }
}