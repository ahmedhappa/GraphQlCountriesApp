package com.example.myfirstgraphqlapp.data.remote

import com.apollographql.apollo3.ApolloClient
import com.example.myfirstgraphqlapp.data.mapper.toCountry
import com.example.myfirstgraphqlapp.domain.model.Country
import com.example.myfirstgraphqlapp.domain.remote.CountryClient
import com.myfirstgraphqlapp.CountriesQuery
import com.myfirstgraphqlapp.CountryQuery
import javax.inject.Inject

class ApolloCountryClient @Inject constructor(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<Country> {
        return apolloClient.query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): Country? {
        return apolloClient.query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toCountry()
    }
}