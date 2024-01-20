package com.example.myfirstgraphqlapp.presentation

import com.example.myfirstgraphqlapp.domain.model.Country

data class CountriesState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val selectedCountry: Country? = null
)

sealed interface CountriesAction {
    data class SelectCountry(val code: String) : CountriesAction
    data object DismissCountryDialog : CountriesAction
}