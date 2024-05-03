package app.getevents.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.tools.FormatDate
import app.getevents.tools.FormatDateHeure
import app.getevents.tools.imageUrl
import app.getevents.ui.MainViewModel
import app.getevents.ui.composable.BaseDetailEvenement
import app.getevents.ui.composable.CardMiniProjet
import app.getevents.ui.composable.DetailEvenement
import app.getevents.ui.composable.ErrorComposable
import app.getevents.ui.composable.Loading
import app.getevents.ui.composable.TitleEvenement
import app.getevents.ui.navigation.Route
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ConcoursScreen(
    id : Int,
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavController
){
    val uiStateConcoursprojet = mainViewModel.uiStateConcoursprojet.value
    LaunchedEffect(Unit){
        mainViewModel.getConcoursProjetByPk(id)
    }
    
    BaseScreen(
        title = "GET Concours" , 
        isSearchBar = false, 
        navController = navController
    ) {
        if (uiStateConcoursprojet.isLoading){
            Loading(400)
        } else if(!uiStateConcoursprojet.error.isNullOrEmpty()){
            ErrorComposable(error = uiStateConcoursprojet.error, height = 400)
        } else {
            uiStateConcoursprojet.data?.let {concoursProjet->
                TitleEvenement(
                    title = concoursProjet.title,
                    date = FormatDate(concoursProjet.date),
                    image = imageUrl(url = concoursProjet.url)
                )
            }

            uiStateConcoursprojet.data?.let { concoursProjet ->
                BaseDetailEvenement {
                    DetailEvenement(
                        title = "Description :",
                        description =concoursProjet.description
                    )
                    DetailEvenement(
                        title = "Jurry :",
                        description = concoursProjet.jurry
                    )
                    DetailEvenement(
                        title = "Quand ?",
                        description = FormatDateHeure(concoursProjet.date)
                    )
                    DetailEvenement(
                        title = "Ou ?",
                        description = concoursProjet.lieu
                    )
                    Column(
                        Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Les mini-projets :",
                            fontFamily = acmeFont,
                            fontSize = 14.sp,
                            color = CustomColors.onPrimary,
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        concoursProjet.miniprojets.forEach { miniProjet ->
                            CardMiniProjet(title =  miniProjet.title, url = miniProjet.image , vote = miniProjet.vote_public, onClick = { navController.navigate("${Route.MiniScreen.itineraire}/${miniProjet.id}") } )
                        }
                    }
                }
            }

        }
    }
}
