package com.example.myfirstgraphqlapp.presentation

import android.icu.util.ULocale.getCountry
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstgraphqlapp.domain.usecase.GetCountriesUseCase
import com.example.myfirstgraphqlapp.domain.usecase.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        getCountries()
    }

    fun onAction(action: CountriesAction) {
        when (action) {
            is CountriesAction.SelectCountry -> selectCountry(action.code)
            is CountriesAction.DismissCountryDialog -> _state.update {
                it.copy(selectedCountry = null)
            }
        }
    }

    private fun getCountries() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val countries = getCountriesUseCase()
            _state.update {
                it.copy(
                    isLoading = false,
                    countries = countries
                )
            }
        }
    }

    private fun selectCountry(code: String) {
        viewModelScope.launch {
            val country = getCountryUseCase(code)
            _state.update {
                it.copy(selectedCountry = country)
            }
        }
    }
}