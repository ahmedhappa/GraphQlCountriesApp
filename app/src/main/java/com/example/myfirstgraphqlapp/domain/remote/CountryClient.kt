package com.example.myfirstgraphqlapp.domain.remote

import com.example.myfirstgraphqlapp.domain.model.Country

interface CountryClient {

    suspend fun getCountries(): List<Country>

    suspend fun getCountry(code: String): Country?
}