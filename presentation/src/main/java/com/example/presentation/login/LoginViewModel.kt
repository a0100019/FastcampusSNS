package com.example.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(), ContainerHost<LoginState, LoginSideEffect> {

    fun onLoginClick() {
        val id = ""
        val password = ""
        viewModelScope.launch {
            loginUseCase(id, password)
        }
    }

    //아이디 입력 가능하게 하는 코드
    fun onIdChange(id: String) = intent {
        reduce {
            state.copy(id = id)
        }

    }

    fun onPasswordChange(password: String) = intent {
        reduce {
            state.copy(password = password)
        }

    }

    override val container: Container<LoginState, LoginSideEffect> = container(
        initialState = LoginState()
    )

}

@Immutable
data class LoginState(
    val id:String = "",
    val password:String = "",
)

sealed interface LoginSideEffect