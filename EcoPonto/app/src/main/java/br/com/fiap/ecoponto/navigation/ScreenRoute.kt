package br.com.fiap.ecoponto.navigation

sealed class Destination(val route: String){

    object Login : Destination("login")

    object Register : Destination("register")

    object Home : Destination("home/{email}")
    {
        fun createRoute(
            email: String
        ): String
        {
            return "home/$email"
        }

    }

    object Descarte : Destination("descarte")

    object Resultado : Destination("resultado")

    object Mapa : Destination ("mapa")

    object Perfil : Destination("perfil")

}