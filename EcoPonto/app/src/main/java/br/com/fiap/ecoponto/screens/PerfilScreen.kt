package br.com.fiap.ecoponto.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecoponto.R
import br.com.fiap.ecoponto.navigation.Destination
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme
import java.nio.file.WatchEvent

@Composable
fun PerfilScreen(
    navController: NavController
) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

    ){
        Scaffold (
            topBar = {MyTop(navController)},
            containerColor = MaterialTheme.colorScheme.background,
        ){innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp)
                    .background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                ContentScreen(navController)
            }

         }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(navController: NavController) {

    TopAppBar(
            title = {
                Text(
                    text = "Voltar",
                    style = MaterialTheme.typography.titleMedium
                )
            },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = ""
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground
        )

    )
    
}






@Composable
fun ContentScreen( navController: NavController) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.editar),
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
            )

            Text(
                text = "Usuario EcoPonto"
            )

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp)
                .height(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            shape = RoundedCornerShape(28.dp)
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Informações pessoais"
                )

                Text(
                    text = "Nome: Usuario EcoPonto"
                )

                Text(
                    text = "Email: usuario@gmail.com"
                )
            }
        }

        Button(
            onClick = {
                navController.navigate(
                    Destination.Login.route
                ){
                    popUpTo(Destination.Home.route){
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "Sair da Conta"
            )
        }


    }
}

//Preview

@Preview
@Composable
private fun PerfilScreenPreview() {
    EcoPontoTheme {
        PerfilScreen(
            rememberNavController()
        )
    }
    
}


@Preview
@Composable
private fun MyTopPreview() {
    EcoPontoTheme {
        MyTop(rememberNavController())
    }

}
@Preview
@Composable
private fun ContentScreenPreview() {
    EcoPontoTheme {
        ContentScreen(rememberNavController())
    }
    
}