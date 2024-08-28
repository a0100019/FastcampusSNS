package com.example.data.di

import com.example.data.retrofit.FCInterceptor
import com.example.data.retrofit.FileService
import com.example.data.retrofit.UserService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

//http 쓸려면 xml에 network_security_config.xml 만들고 메니페스트에도 추가 (보안상 위험해도 무시)
val FC_HOST = "http://10.201.21.25:8080"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {


    @Provides
    fun provideOkHttpClient(interceptor: FCInterceptor):OkHttpClient{
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val contentType = "application/json; charset=utf-8".toMediaType()
        val converterFactory = Json {
            ignoreUnknownKeys = true
        }.asConverterFactory(contentType)
        return Retrofit.Builder()
            .baseUrl("${FC_HOST}/api/")
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }


    @Provides
    fun provideUserService(retrofit:Retrofit):UserService{
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun provideFileService(retrofit:Retrofit): FileService {
        return retrofit.create(FileService::class.java)
    }
}