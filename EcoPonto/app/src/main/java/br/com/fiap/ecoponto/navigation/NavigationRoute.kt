package br.com.fiap.ecoponto.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import br.com.fiap.ecoponto.screens.DescarteScreen
import br.com.fiap.ecoponto.screens.HomeScreen
import br.com.fiap.ecoponto.screens.LoginScreen
import br.com.fiap.ecoponto.screens.PerfilScreen
import br.com.fiap.ecoponto.screens.MapaScreen
import br.com.fiap.ecoponto.screens.RegisterScreen

@Composable
fun NavigationRoute() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.Login.route
    ) {

        composable (
            route = Destination.Descarte.route
        ){
            DescarteScreen(navController)
        }

        composable (
            route = Destination.Mapa.route
        ){
            MapaScreen(navController)
        }

        composable(
            route = Destination.Login.route
        ){
            LoginScreen(navController)
        }

        composable (
            route = Destination.Register.route
        ){
            RegisterScreen(navController)
        }

        composable(
            route = Destination.Home.route
        ) {
            HomeScreen(navController)
        }

        composable (
            route = Destination.Perfil.route
        ){
            PerfilScreen(navController)
        }

    }

}