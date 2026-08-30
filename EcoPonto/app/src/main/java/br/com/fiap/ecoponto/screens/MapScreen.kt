package br.com.fiap.ecoponto.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecoponto.components.CardPontoColeta
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme

@Composable
fun MapaScreen(navController: NavController) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

    ){
        Scaffold (
            topBar = {MyTopMapa(navController)}
        ){innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                ContentScreenMapa()
            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopMapa(
    navController: NavController
) {
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
                    contentDescription = "Voltar"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor =
                MaterialTheme.colorScheme.onBackground
        )
    )
}

@Composable
fun ContentScreenMapa(
    modifier: Modifier = Modifier
) {
    var endereco by remember {
        mutableStateOf("")
    }

    //Area de pesquisa, não funciona esperando API
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Encontre um ponto de coleta",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 24.dp)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Pesquise pelo seu endereço ou bairro.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        //Arrumar para funcionar os botões para pesquisar
        OutlinedTextField(
            value = endereco,
            onValueChange = {
                endereco = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Endereço ou bairro")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar"
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(20.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))


        //Box só para deixar um espaço para a inserção da API
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Localização",
                    modifier = Modifier.size(48.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Mapa disponível em breve",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Pontos próximos",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))


        //Coluna de Cards do Component CardPontoColeta(substituivel para API)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            CardPontoColeta(
                nome = "Ecoponto Central",
                endereco = "Rua das Flores, 120",
                materiais = "Papel, plástico, vidro e metal",
                distancia = "1,2 km"
            )

            Spacer(modifier = Modifier.height(12.dp))

            CardPontoColeta(
                nome = "Estação de Reciclagem",
                endereco = "Avenida Verde, 450",
                materiais = "Eletrônicos e pilhas",
                distancia = "2,5 km"
            )

            Spacer(modifier = Modifier.height(12.dp))

            CardPontoColeta(
                nome = "Cooperativa EcoVida",
                endereco = "Rua das Palmeiras, 82",
                materiais = "Papel, plástico e metal",
                distancia = "3,1 km"
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}



@Preview
@Composable
private fun MapaScreenPreview() {
    EcoPontoTheme {
        MapaScreen(rememberNavController())
    }

}