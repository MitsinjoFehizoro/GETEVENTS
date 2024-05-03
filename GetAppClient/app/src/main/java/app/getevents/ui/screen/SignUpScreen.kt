package app.getevents.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.getevents.ui.composable.BaseAuth
import app.getevents.ui.composable.ChampText
import app.getevents.ui.composable.PrimaryBtnAuth
import app.getevents.ui.composable.SecondaryBtnAuth
import app.getevents.ui.navigation.Route

@Composable
fun SignUpScreen(
    navController: NavController
){
    BaseAuth(navController) {
        val numero = remember { mutableStateOf("") }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            ChampText(value = numero, placeholder = "Numero d'inscription")
            ChampText(value = numero, placeholder = "Pseudo")
            ChampText(value = numero, placeholder = "Mot de passe")

            PrimaryBtnAuth(text = "Creer un compte")
        }


        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            SecondaryBtnAuth(text = "Se connecter à un autre compte", onClick = { navController.navigate(Route.LoginScreen.itineraire) })
        }
    }
}




