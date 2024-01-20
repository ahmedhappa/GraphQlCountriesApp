package com.example.myfirstgraphqlapp.di

import com.example.myfirstgraphqlapp.data.remote.ApolloCountryClient
import com.example.myfirstgraphqlapp.domain.remote.CountryClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CountryClientModule {

    @Binds
    @Singleton
    abstract fun bindCountryClient(apolloCountryClient: ApolloCountryClient): CountryClient

}