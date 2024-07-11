package com.example.data.di

import com.example.data.usecase.LoginUseCaseImpl
import com.example.domain.usecase.login.LoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    //바인즈 에너테이션 쓸때는 무조건 abstract class로
    @Binds
    abstract fun bindLoginUseCase(uc:LoginUseCaseImpl):LoginUseCase
}