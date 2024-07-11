package com.example.data.usecase

import com.example.domain.usecase.login.LoginUseCase
import javax.inject.Inject


//id와 비번을 받아서 토큰 반환
class LoginUseCaseImpl @Inject constructor() : LoginUseCase {
    override suspend fun invoke(id: String, password: String): Result<String> = kotlin.runCatching {
        "token"
    }
}