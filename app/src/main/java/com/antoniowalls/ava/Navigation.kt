package com.antoniowalls.ava

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antoniowalls.ava.pages.LoginScreen
import com.antoniowalls.ava.pages.SignUpScreen
import com.antoniowalls.ava.pages.HomeScreen


@Composable
fun Navigation(modifier: Modifier= Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController= navController, startDestination = "Login", builder = {
        composable("login"){
            LoginScreen(modifier, navController, authViewModel )
        }
        composable("signup"){
            SignUpScreen(modifier, navController, authViewModel )
        }
        composable("home"){
            HomeScreen(modifier, navController, authViewModel )
        }
    })
}
