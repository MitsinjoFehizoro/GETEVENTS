package app.getevents.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.ui.MainViewModel
import app.getevents.ui.composable.BaseAuth
import app.getevents.ui.composable.ChampText
import app.getevents.ui.composable.ErrorComposable
import app.getevents.ui.composable.PrimaryBtnAuth
import app.getevents.ui.composable.SecondaryBtnAuth
import app.getevents.ui.navigation.Route
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginScreen(
    navController : NavController,
    mainViewModel: MainViewModel = hiltViewModel()
){

    val uiStateStudent = mainViewModel.uiStateStudent.value
    val uiStateUser = mainViewModel.uiStateUser.value
    val retour = mutableStateOf("")

    BaseAuth(navController) {
        val numero = remember { mutableStateOf("") }
        val password = mutableStateOf("")

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ChampText(value = numero, placeholder = "Numero d'inscription")
            ChampText(value = password, placeholder = "Mot de passe")

            val loading = remember {
                mutableStateOf(false)
            }
            PrimaryBtnAuth(
                text = "Se connecter",
                isLoading = loading.value,
                onClick = {
                    loading.value = true
                    mainViewModel.getStudentByPk(numero.value)
                }
            )

            if(uiStateStudent.isLoading){
            } else if(!uiStateStudent.error.isNullOrEmpty()){
                ErrorComposable(error = uiStateStudent.error, height = 100)
            } else {
                uiStateStudent.data?.let {data->
                    if(data.size > 0){
                        mainViewModel.getUser(numero.value)
                        retour.value = "En attente de developpement."
                    } else {
                        retour.value = "Numero d'inscription invalide!!!"
                    }
                    loading.value = false
                }
            }


            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = retour.value,
                fontFamily = acmeFont,
                fontSize = 12.sp,
                color = Color.Red,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Mot de passe oublie ?",
                fontFamily = acmeFont,
                fontSize = 16.sp,
                color = CustomColors.onPrimary,
                textAlign = TextAlign.Center
            )
        }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            SecondaryBtnAuth(text = "Créer un compte", onClick = { navController.navigate(Route.SignUpScreen.itineraire) })
        }
    }
}




