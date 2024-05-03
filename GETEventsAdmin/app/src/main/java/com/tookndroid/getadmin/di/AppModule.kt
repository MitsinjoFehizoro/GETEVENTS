package com.tookndroid.getadmin.di

import com.tookndroid.getadmin.data.api.GetApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
private const val BASE_URL_EVENT = "https://apirestget.onrender.com"

    @Singleton
    @Provides
    fun provideRetrofit (): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_EVENT)
            .build()
    }

    @Singleton
    @Provides
    fun provideGetApi(retrofit: Retrofit) : GetApi{
        return retrofit.create(GetApi::class.java)
    }

}
