package br.com.fiap.ecoponto.navigation
import android.net.Uri
sealed class Destination(val route: String){

    object Login : Destination("login")

    object Register : Destination("register")

    object Home : Destination("home/{email}")
    {
        fun createRouteHome(
            email: String
        ): String
        {
            return "home/$email"
        }

    }

    object Descarte : Destination("descarte")

    object Mapa : Destination ("mapa")

    object Perfil : Destination(
        route = "perfil?name={name}&email={email}"
    ) {
        fun createRoutePerfil(
            name: String,
            email: String
        ): String {
            return "perfil?name=${Uri.encode(name)}&email=${Uri.encode(email)}"
        }
    }
}