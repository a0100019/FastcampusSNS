package com.example.presentation.login

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.login.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.annotation.concurrent.Immutable
import javax.inject.Inject
import kotlin.math.sign

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel(),
    ContainerHost<SignUpState, SignUpSideEffect> {
    override val container: Container<SignUpState, SignUpSideEffect> = container(
        initialState = SignUpState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent { postSideEffect(SignUpSideEffect.Toast(throwable.message.orEmpty())) }
            }
        }
    )

        //가끔 입력 순서가 꼬이는 것을 방지한다, 텍스트 필드 한해서 사용하자 - blockingIntent
    fun onIdChange(id: String) = blockingIntent {
        reduce { state.copy(id = id)}
    }

    fun onUsernameChange(username: String) = blockingIntent {
        reduce { state.copy(username = username)}
    }
    fun onPasswordChange(pa: String) = blockingIntent {
        reduce { state.copy(password = pa)}
    }
    fun onRepeatPasswordChange(pa: String) = blockingIntent {
        reduce { state.copy(repeatPassword = pa)}
    }



    fun onSignUpClick() = intent{
        if(state.password != state.repeatPassword){
            postSideEffect(SignUpSideEffect.Toast(message = "두 패스워드가 일치하지 않습니다."))
            return@intent
        }
        val isSuccessful = signUpUseCase(
            id = state.id,
            username = state.username,
            password = state.password
        ).getOrThrow()

        if(isSuccessful){
            postSideEffect(SignUpSideEffect.NavigateToLoginScreen)
            postSideEffect(SignUpSideEffect.Toast("회원가입 성공"))

        }
    }
}

@Immutable
data class SignUpState(
    val id: String = "",
    val username: String = "",
    val password: String = "",
    val repeatPassword: String = "",
)

sealed interface SignUpSideEffect {
    class Toast(val message: String) : SignUpSideEffect

    object NavigateToLoginScreen : SignUpSideEffect
}