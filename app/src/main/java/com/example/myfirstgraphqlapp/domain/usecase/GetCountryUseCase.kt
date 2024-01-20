package com.example.myfirstgraphqlapp.domain.usecase

import com.example.myfirstgraphqlapp.domain.model.Country
import com.example.myfirstgraphqlapp.domain.remote.CountryClient
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val countryClient: CountryClient
) {
    suspend operator fun invoke(code: String): Country? {
        return countryClient.getCountry(code)
    }
}