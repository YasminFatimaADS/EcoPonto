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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.ecoponto.navigation.Destination
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecoponto.R
import br.com.fiap.ecoponto.ui.theme.EcoPontoTheme

@Composable
fun RegisterScreen(navController: NavController) {

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            TitleRegister(navController)
            FormRegister(navController)
        }
    }
    
}

@Composable
fun TitleRegister(navController: NavController) {

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
            text = "Criar Conta",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Cadastre-se para utilizar o EcoPonto",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
    
}


@Composable
fun FormRegister(navController: NavController) {

    var nameRegisterState = remember {
        mutableStateOf("")
    }

    var emailRegisterState = remember {
        mutableStateOf("")
    }

    var senhaRegisterState = remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){

        //NOME COMPLETO DO CADASTRO
        OutlinedTextField(
            value = nameRegisterState.value,
            onValueChange = {nameMutable ->
                nameRegisterState.value = nameMutable
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),

            label = {
                Text(
                    text = "Nome completo",
                    style = MaterialTheme.typography.bodySmall
                )
            },
            shape = RoundedCornerShape(28.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "perfil"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )

        )
        Spacer(modifier = Modifier.height(16.dp))

        //EMAIL DO CADASTRO
        OutlinedTextField(
            value = emailRegisterState.value,
            onValueChange = {emailMutable ->
                emailRegisterState.value = emailMutable
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
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground
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

        //SENHA DO CADASTRO
        OutlinedTextField(
            value = senhaRegisterState.value,
            onValueChange = {senhaMutable ->
                senhaRegisterState.value = senhaMutable

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
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground
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

        //Botão para ir para o Login
        Button(
            onClick = {
                navController.navigate(
                    Destination.Login.route
                )
            },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Criar Conta",
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
                text = "Já possui conta?",
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodySmall
            )

            //Botão para ir para a pagina Login
            TextButton(
                onClick = {
                    navController.navigate(
                        Destination.Login.route
                    )
                }
            ) {
                Text(
                    text = "Entrar",
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
private fun RegisterScreenPreview() {
    EcoPontoTheme {
        RegisterScreen(rememberNavController())
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun TitleRegisterPreview() {
    EcoPontoTheme {
        TitleRegister(rememberNavController())
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun FormRegisterPreview() {
    EcoPontoTheme {
        FormRegister(rememberNavController())
    }

}