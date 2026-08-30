package br.com.fiap.ecoponto.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun CardDescarte(
    titulo: String,
    descricao: String,
    imagemFrente: Painter,
    imagemDetalhes: Painter,
    cor: Color,
    modifier: Modifier = Modifier
) {
    var mostrarDetalhes by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp)
            .clickable {
                mostrarDetalhes = !mostrarDetalhes
            },
        colors = CardDefaults.cardColors(
            containerColor = cor
        ),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
    ) {
        if (mostrarDetalhes) {

            InformacaoDescarte(
                titulo = titulo,
                descricao = descricao,
                imagem = imagemDetalhes
            )

        } else {

            ApresentacaoDescarte(
                titulo = titulo,
                imagem = imagemFrente
            )
        }
    }
}

@Composable
fun ApresentacaoDescarte(
    titulo: String,
    imagem: Painter
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagem,
            contentDescription = titulo,
            modifier = Modifier.size(56.dp)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = titulo,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = "Toque para ver",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun InformacaoDescarte(
    titulo: String,
    descricao: String,
    imagem: Painter
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagem,
            contentDescription = titulo,
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = titulo,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Text(
                text = descricao,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Toque novamente para voltar",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

