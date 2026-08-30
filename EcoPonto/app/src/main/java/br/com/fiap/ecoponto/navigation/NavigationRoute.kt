package br.com.fiap.ecoponto.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import br.com.fiap.ecoponto.screens.HomeScreen
import br.com.fiap.ecoponto.screens.LoginScreen
import br.com.fiap.ecoponto.screens.RegisterScreen

@Composable
fun NavigationRoute() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.Login.route
    ) {

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
            route = Destination.Home.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://ecoponto.fiap.com.br/email/{email}"
                    action = Intent.ACTION_VIEW
                }),
            arguments = listOf(navArgument ("email"){ type = NavType.StringType })
        ) {backStackEntry ->
            var email = backStackEntry.arguments?.getString("email")
            HomeScreen(navController,email)
        }
    }

}