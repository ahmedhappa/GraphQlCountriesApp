package com.example.myfirstgraphqlapp.data.mapper

import com.example.myfirstgraphqlapp.domain.model.Country
import com.myfirstgraphqlapp.CountriesQuery
import com.myfirstgraphqlapp.CountryQuery

fun CountriesQuery.Country.toCountry() = Country(
    code = code,
    name = name,
    capital = capital ?: "No capital",
    emoji = emoji,
    currency = null,
    languages = emptyList(),
    continents = null
)

fun CountryQuery.Country.toCountry() = Country(
    code = code,
    name = name,
    capital = capital?: "No capital",
    emoji = emoji,
    currency = currency?: "No currency",
    languages = languages.map { it.name },
    continents = continent.name
)