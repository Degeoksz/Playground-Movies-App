package com.example.data.di

import com.example.data.utils.BuildConfigProvider
import com.example.data.service.api.MovieApi
import com.example.data.utils.Constants.ACCEPT
import com.example.data.utils.Constants.APPLICATION_JSON
import com.example.data.utils.Constants.AUTHORIZATION
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Evaluate if API classes can be moved into another module with a different scope
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    fun provideConverterFactory(): Converter.Factory =
        GsonConverterFactory.create(GsonBuilder().create())

    @Provides
    fun provideOkHttpClient(buildConfigProvider: BuildConfigProvider): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                Interceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader(ACCEPT, APPLICATION_JSON)
                        .addHeader(AUTHORIZATION, buildConfigProvider.getApiKey())
                        .build()
                    chain.proceed(request)
                }
            ).addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }).build()

    @Provides
    fun provideRetrofit(
        buildConfigProvider: BuildConfigProvider,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(buildConfigProvider.getApiUrl())
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    internal fun provideMovieApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}
