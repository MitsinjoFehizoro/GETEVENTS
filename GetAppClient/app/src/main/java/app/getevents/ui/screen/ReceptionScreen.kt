package app.getevents.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.tools.FormatDate
import app.getevents.tools.FormatDateHeure
import app.getevents.tools.imageUrl
import app.getevents.ui.MainViewModel
import app.getevents.ui.composable.BaseDetailEvenement
import app.getevents.ui.composable.DetailEvenement
import app.getevents.ui.composable.ErrorComposable
import app.getevents.ui.composable.Loading
import app.getevents.ui.composable.TitleEvenement

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReceptionScreen(
    id : Int,
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
){

    val uiStateReception = mainViewModel.uiStateReception.value
    LaunchedEffect(Unit){
        mainViewModel.getReceptionByPk(id)
    }

    BaseScreen(
        title = "GET Reception",
        isSearchBar = false,
        navController = navController
    ) {
        if(uiStateReception.isLoading){
            Loading(height = 450)
        } else if(!uiStateReception.error.isNullOrEmpty()){
            ErrorComposable(error = uiStateReception.error, height = 450)
        } else {
            uiStateReception.data?.let {reception->
                TitleEvenement(
                    title = reception.title,
                    date = FormatDate(reception.date),
                    image = imageUrl(url = reception.url)
                )
                BaseDetailEvenement {
                    Image(
                        painter = imageUrl(url = reception.url),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    DetailEvenement(title = "Description :", description = reception.description)
                    DetailEvenement(title = "Quand ?", description = FormatDateHeure(reception.date))
                    DetailEvenement(title = "Ou ?", description = reception.lieu)
                    DetailEvenement(title = "Participation :", description = reception.participation)
                }
            }
        }
    }
}
