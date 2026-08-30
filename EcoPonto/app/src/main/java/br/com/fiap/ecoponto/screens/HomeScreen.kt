package br.com.fiap.ecoponto.screens

import android.content.res.Configuration
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecoponto.R
import br.com.fiap.ecoponto.components.EcoCard
import br.com.fiap.ecoponto.navigation.Destination
import br.com.fiap.ecoponto.ui.theme.EcoAccent
import br.com.fiap.ecoponto.ui.theme.EcoError
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme
import br.com.fiap.ecoponto.ui.theme.EcoWarning

@Composable
fun HomeScreen(navController: NavController) {
    Box ( 
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            TitleHome()
            CardHome(navController)
        }
    }
    
}

@Composable
fun TitleHome() {

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        Image(
            painterResource(R.drawable.lixeiradereciclagem),
            contentDescription = ""

        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "EcoPonto",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Bem-vindo(a), Usuario EcoPonto",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.scrim,
                textAlign = TextAlign.Center
            )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Descartar corretamente hoje faz diferença para o amanhã",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.scrim,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun CardHome(navController: NavController) {

    Column (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {

        //carte Descarte
        EcoCard(
            titulo = "O que descartar?",
            cor = EcoWarning,
            imagem = painterResource(R.drawable.lixeira),
            onClick = {
                navController.navigate(
                    Destination.Descarte.route
                )
            },
            descricao = "Consulte materiais recicláveis e orientações para descarte correto."
        )

        //Card Mapa
        EcoCard(
            titulo = "Pontos de coleta",
            cor = EcoError,
            imagem = painterResource(R.drawable.distancia),
            onClick = {
                navController.navigate(
                    Destination.Mapa.route
                )
            },
            descricao = "Encontre ecopontos próximos a você."
        )

        //card perfil
        EcoCard(
            titulo = "Meu Perfil",
            cor = EcoAccent,
            imagem = painterResource(R.drawable.editar),
            onClick = {
                navController.navigate(
                    Destination.Perfil.route
                )
            },
            descricao = "Dados do usuário e histórico de utilização."
        )

    }

    
}




//Preview

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun HomeSreenPreview() {
    EcoPontoTheme {
        HomeScreen(rememberNavController())
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun CarHomePreview() {
    EcoPontoTheme {
        CardHome(rememberNavController())
    }
    
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun TitleHomePreview() {
    EcoPontoTheme {
        TitleHome()
    }

}