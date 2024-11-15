package com.antoniowalls.ava

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel: ViewModel() {

        private val auth: FirebaseAuth = FirebaseAuth.getInstance()
        private val _authState = MutableLiveData<AuthState>()
        val authState: MutableLiveData<AuthState> = _authState

        init {
                checkAuthStatus()
        }

        fun checkAuthStatus() {
                // Verifica si el usuario ya está autenticado
                if (auth.currentUser != null) {
                        _authState.value = AuthState.Authenticated // Usuario ya está autenticado
                } else {
                        _authState.value = AuthState.Unauthenticated // Usuario no autenticado
                }
        }

        fun login(email : String, password : String){
                if(email.isEmpty() || password.isEmpty()){
                        _authState.value = AuthState.Error("El correo o la contraseña no pueden estar vacíos")
                        return
                }
                _authState.value = AuthState.Loading
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                        _authState.value = AuthState.Authenticated
                                }else{
                                        _authState.value = AuthState.Error(task.exception?.message ?: "Algo ha salido mal")
                                }
                        }
        }

        fun signup(email : String, password : String){
                if(email.isEmpty() || password.isEmpty()){
                        _authState.value = AuthState.Error("El correo o la contraseña no pueden estar vacíos")
                        return
                }
                _authState.value = AuthState.Loading
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                        _authState.value = AuthState.Authenticated
                                }else{
                                        _authState.value = AuthState.Error(task.exception?.message ?: "Algo ha salido mal")
                                }
                        }
        }

        fun signOut(){
                auth.signOut()
                _authState.value = AuthState.Unauthenticated
        }

}

sealed class AuthState{
        object Authenticated : AuthState()
        object Unauthenticated : AuthState()
        object Loading : AuthState()
        data class Error(val message: String) : AuthState()
}