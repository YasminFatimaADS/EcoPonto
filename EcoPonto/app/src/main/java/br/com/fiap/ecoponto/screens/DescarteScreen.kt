package br.com.fiap.ecoponto.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecoponto.components.CardDescarte
import br.com.fiap.ecoponto.R
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme

@Composable
fun DescarteScreen(navController: NavController) {

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

    ){
        Scaffold (
            topBar = { MyTopDescarte(navController) }
        ){innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                ContentScreenDescarte()
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopDescarte(navController: NavController) {

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
fun ContentScreenDescarte(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "O que você deseja descartar?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 24.dp)
        )

        Text(
            text = "Selecione uma categoria para ver\n" +
                    "as orientações de descarte.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 24.dp)
        )

        CardDescarte(
            titulo = "Papel",
            descricao = """
            Descarte folhas, jornais, revistas, cadernos e caixas de papelão limpos e secos.
            Não descarte papel higiênico, guardanapos sujos, papéis molhados ou engordurados.
            """.trimIndent(),
            imagemFrente = painterResource(R.drawable.reciclar),
            cor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(vertical = 8.dp),
            imagemDetalhes = painterResource(R.drawable.papel)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardDescarte(
            titulo = "Plástico",
            descricao = """
            Descarte garrafas PET, potes, tampas e embalagens plásticas.
            Retire os restos de alimentos, enxágue quando necessário e deixe as embalagens secas.
            """.trimIndent(),
            imagemFrente = painterResource(R.drawable.reciclar),
            cor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(vertical = 8.dp),
            imagemDetalhes = painterResource(R.drawable.garrafadeagua)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardDescarte(
            titulo = "Vidro",
            descricao = """
            Descarte garrafas, potes e frascos de vidro limpos.
            Embale vidros quebrados com segurança e identifique o pacote. Lâmpadas e espelhos precisam de coleta específica.
            """.trimIndent(),
            imagemFrente = painterResource(R.drawable.reciclar),
                    cor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(vertical = 8.dp),
            imagemDetalhes = painterResource(R.drawable.vidroquebrado)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardDescarte(
            titulo = "Metal",
            descricao = """
            Descarte latas de alumínio, latas de conserva, tampas metálicas e papel-alumínio limpo.
            Esvazie as embalagens e retire restos de alimentos antes do descarte.
            """.trimIndent(),
            imagemFrente = painterResource(R.drawable.reciclar),
            cor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(vertical = 8.dp),
            imagemDetalhes = painterResource(R.drawable.latadecerveja)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardDescarte(
            titulo = "Eletrônicos",
            descricao = """
            Celulares, cabos, carregadores e pequenos aparelhos não devem ir para o lixo comum.
            Leve os equipamentos até um ponto de coleta ou estabelecimento que receba eletrônicos.
            """.trimIndent(),
            imagemFrente = painterResource(R.drawable.reciclar),
            cor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(vertical = 8.dp),
            imagemDetalhes = painterResource(R.drawable.dispositivo)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardDescarte(
            titulo = "Orgânico",
            descricao = """
            Separe cascas, sementes, borra de café e restos de alimentos.
            Quando possível, utilize uma composteira. Não misture resíduos orgânicos com materiais recicláveis.
             """.trimIndent(),
            imagemFrente = painterResource(R.drawable.reciclar),
            cor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(vertical = 8.dp),
            imagemDetalhes = painterResource(R.drawable.composto)
        )

        Text(
            text = "A aceitação dos materiais pode variar. " +
                    "Consulte as orientações do ponto de coleta da sua região.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 24.dp)
        )

    }
}


//Preview
@Preview
@Composable
fun ContentScreenDescartePreview() {
    EcoPontoTheme {
        ContentScreenDescarte()
    }

}

@Preview
@Composable
private fun DescarteScreenPreview() {
    EcoPontoTheme {
        DescarteScreen(rememberNavController())
    }
    
}