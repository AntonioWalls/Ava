package com.antoniowalls.ava

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize // Import fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier // Import the correct Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column( //todo lo que este dentro de aquí sirve para centrarlo
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.img_ava), contentDescription = "Ava Logo", modifier = Modifier.size(200.dp)) //ajusta el logo al centro de la pantalla y le asigna un tamaño de 200dp

        //textp de bienvenida
        Text(text = "¡Bienvenido usuario!", fontSize = 25.sp) //poniendole estilo al texto

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Inicia sesión", fontSize = 20.sp)

        //campo correo
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(value = "email",
            onValueChange = { newEmail ->
            email = newEmail
        },
            label =
            { Text("Correo electrónico") })

        //campo contraseña
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "password",
            onValueChange = { newPassword ->
            password = newPassword
        },
            label =
            { Text("Contraseña") }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp)) //boton de inicio de sesión
        Button(onClick ={} ) {
            Text(text = "Iniciar Sesión")
        }

        Spacer(modifier = Modifier.height(16.dp)) //texto que se puede clickear
        Text(text = "¿Olvidaste tu contraseña?", modifier = Modifier.clickable {

        })

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "o")

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {}) {
            Text(text = "Crear cuenta")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically // Centra verticalmente
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Acción a realizar al hacer clic en la imagen
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Acción a realizar al hacer clic en la imagen
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Twitter",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Acción a realizar al hacer clic en la imagen
                    }
            )
        }


    }
}