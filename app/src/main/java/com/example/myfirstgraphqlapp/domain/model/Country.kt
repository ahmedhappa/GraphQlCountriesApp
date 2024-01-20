package com.example.myfirstgraphqlapp.domain.model

data class Country(
    val code: String,
    val name: String,
    val capital: String,
    val emoji: String,
    val currency: String?,
    val languages: List<String>,
    val continents: String?
)
