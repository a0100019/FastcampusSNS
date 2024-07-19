package com.example.data.usecase

import com.example.data.model.LoginParam
import com.example.data.retrofit.UserService
import com.example.domain.usecase.login.LoginUseCase
import javax.inject.Inject


//id와 비번을 받아서 토큰 반환
class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService,
) : LoginUseCase {
    override suspend fun invoke(id: String, password: String): Result<String> = kotlin.runCatching {
        val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
        userService.login(requestBody = requestBody).data
    }
}