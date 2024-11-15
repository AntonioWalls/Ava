@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.antoniowalls.ava.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.antoniowalls.ava.AuthState
import com.antoniowalls.ava.AuthViewModel
import com.antoniowalls.ava.R

@Preview
@Composable
fun SignupPagePreview() {
    // Pasamos valores predeterminados para los parámetros
    SignupPage(navController = NavController(context = LocalContext.current), authViewModel = AuthViewModel())
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var names by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }


    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        //fondo de pantalla
        Image(
            painter = painterResource(id = R.drawable.background_blur),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top, // Mueve todos los elementos hacia la parte superior
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.img_ava), contentDescription = "Ava Logo", modifier = Modifier.size(200.dp))

            Spacer(modifier = Modifier.height(130.dp))  // Ajuste reducido entre logo y formulario
            Text(
                text = "Regístrate",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth(0.8f)  // Ocupa el mismo ancho que el campo de entrada
                    .align(Alignment.Start) // Alinea el texto a la izquierda
                    .padding(start = 34.dp) // Ajusta este valor para que coincida con el borde del input de correo
            )

            //input de correo electronico
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { newEmail -> email = newEmail },
                label = { Text("Correo electrónico", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            //input de telefono
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = phone,
                onValueChange = { newPhone -> phone = newPhone },
                label = { Text("Telefono", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            //input de contraseña
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                label = { Text("Contraseña", color = Color.White) },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            //input de nombre completo
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = names,
                onValueChange = { newNames -> names = newNames },
                label = { Text("Nombre Completo", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            //input de nombre de usuario
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = user,
                onValueChange = { newUser -> user = newUser },
                label = { Text("Nombre de usuario", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    authViewModel.signup(email, password)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text(text = "Crear cuenta")
            }
        }
    }
}
