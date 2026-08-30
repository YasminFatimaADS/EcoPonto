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
import br.com.fiap.ecoponto.navigation.Destination
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme

@Composable
fun HomeScreen(navController: NavController,
               email: String?) {
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
            TitleHome(email!!)
            CardHome(navController)
        }
    }
    
}

@Composable
fun TitleHome(email: String?) {

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        Image(
            painterResource(R.drawable.ordenacao),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "EcoPonto",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row (){
            Text(
                text = "Bem-vindo(a), ",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.scrim,
                textAlign = TextAlign.Center
            )
            Text(
                text = email ?: "Usuario",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.scrim,
                textAlign = TextAlign.Center
            )

        }
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

//card Descarte
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(20.dp)
            .clickable(
                onClick = {
                    navController.navigate(
                        Destination.Descarte.route
                    )
                }
            ),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onTertiary
            ),
            border = BorderStroke(
                width = 3.dp,
                color = MaterialTheme.colorScheme.primary
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.lixeira),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "O que descartar?",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Consulte materiais recicláveis e orientações para descarte correto.",
                    textAlign =  TextAlign.Center

                )
            }

        }

        //card Mapa
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(20.dp)
            .clickable(
                onClick = {
                    navController.navigate(
                        Destination.Mapa.route
                    )
                }
            ),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.error
            ),
            border = BorderStroke(
                width = 3.dp,
                color = MaterialTheme.colorScheme.primary
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.lixeira),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Pontos de coleta",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Encontre ecopontos próximos a você.",
                    textAlign =  TextAlign.Center

                )
            }

        }

        //card perfil
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(20.dp)
            .clickable(
                onClick = {
                    navController.navigate(
                        Destination.Perfil.route
                    )
                }
            ),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            border = BorderStroke(
                width = 3.dp,
                color = MaterialTheme.colorScheme.primary
            )
        ) {

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.lixeira),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Meu Perfil",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Dados do usuário e histórico de utilização.",
                    textAlign =  TextAlign.Center

                )
            }

        }

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
        HomeScreen(rememberNavController(),"")
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
        TitleHome("")
    }

}