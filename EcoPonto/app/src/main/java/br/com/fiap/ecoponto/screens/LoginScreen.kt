package br.com.fiap.ecoponto.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecoponto.R
import br.com.fiap.ecoponto.navigation.Destination
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme

@Composable
fun LoginScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleLogin()
            Spacer(modifier = Modifier.height(40.dp))
            FormLogin(navController)
        }
    }
    
}

@Composable
fun TitleLogin(modifier: Modifier = Modifier) {

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
       Image(
           painterResource(R.drawable.reciclar),
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
            text = "Descarte consciente ao alcance de um mapa",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.scrim
        )
    }

}

@Composable
fun FormLogin(navController: NavController) {

    var emailLoginState = remember {
        mutableStateOf("")
    }

    var senhaLoginState = remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){

        //EMAIL DO LOGIN
        OutlinedTextField(
            value = emailLoginState.value,
            onValueChange = {emailMutable ->
                emailLoginState.value = emailMutable
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            
            label = {
                Text(
                    text = "Insira seu email",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            shape = RoundedCornerShape(28.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.scrim
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "email"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )

            )
        Spacer(modifier = Modifier.height(16.dp))

        //SENHA DO LOGIN
        OutlinedTextField(
            value = senhaLoginState.value,
            onValueChange = {senhaMutable ->
                senhaLoginState.value = senhaMutable

            },
            modifier = Modifier
                .fillMaxWidth(),

            label = {
                Text(
                    text = "Digite sua senha",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            shape = RoundedCornerShape(28.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.scrim
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "senha"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Botão para ir para a home
        Button(
            onClick = {
                navController.navigate(
                    Destination.Home.route
                )
            },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Entrar",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Right
        )
        {

            Text(
                text = "Não possui conta?",
                color = MaterialTheme.colorScheme.scrim,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodySmall
            )

            //Botão para ir para a pagina registrar
            TextButton(
                onClick = {
                    navController.navigate(
                        Destination.Register.route
                    )
                }
            ) {
                Text(
                    text = "Registrar-se",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
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
private fun LoginScreenPreview() {
    EcoPontoTheme {
        LoginScreen(rememberNavController())
    }

}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun TitleLoginPreview() {
    EcoPontoTheme {
        TitleLogin()
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun FormLoginPreview() {
    EcoPontoTheme {
        FormLogin(rememberNavController())
    }

}