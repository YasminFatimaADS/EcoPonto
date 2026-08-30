package br.com.fiap.ecoponto.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.fiap.ecoponto.R
import br.com.fiap.ecoponto.navigation.Destination
import androidx.compose.ui.graphics.Color


@Composable
fun EcoCard(
    titulo: String,
    cor : Color,
    imagem : Painter,
    onClick: () -> Unit,
    descricao : String
    ) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 8.dp)
        .height(120.dp)
        .clickable(
            onClick = onClick
        ),
        colors = CardDefaults.cardColors(
            containerColor = cor.copy(alpha = 0.50f)
        ),
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(
            width = 3.dp,
            color = cor
        )
    ){
        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start

    ) {
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = imagem,
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = titulo,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = descricao,
            textAlign =  TextAlign.Start

        )
        }
    }


}