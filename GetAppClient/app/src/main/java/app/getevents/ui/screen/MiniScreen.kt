package app.getevents.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.getevents.tools.imageUrl
import app.getevents.ui.MainViewModel
import app.getevents.ui.composable.BaseDetailEvenement
import app.getevents.ui.composable.CardStudents
import app.getevents.ui.composable.ErrorComposable
import app.getevents.ui.composable.Loading
import app.getevents.ui.composable.TitleEvenement
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont

@Composable
fun MiniScreen(
    id : Int,
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {

    val uiStateMiniProjet = mainViewModel.uiStateMiniProjet.value
    val uiStateStudent = mainViewModel.uiStateStudent.value
    val studentlist = mainViewModel.studentList
    
    LaunchedEffect(Unit){
        mainViewModel.getMiniProjetByPk(id)
    }

    uiStateMiniProjet.data?.membres?.forEach { id->
        LaunchedEffect(Unit){
            mainViewModel.getStudentByPk(id)
        }
    }


    BaseScreen(
        title = "GET Mini-projet",
        isSearchBar = false,
        navController = navController
    ) {

        if(uiStateMiniProjet.isLoading){
            Loading(height = 400)
        } else if (!uiStateMiniProjet.error.isNullOrEmpty()){
            ErrorComposable(error = uiStateMiniProjet.error, height = 450)
        } else {
            uiStateMiniProjet.data?.let {miniProjet->
                TitleEvenement(
                    title = miniProjet.title,
                    date = miniProjet.theme,
                    vote = miniProjet.vote_public
                )
                BaseDetailEvenement {
                    Column(
                        Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = imageUrl(url = miniProjet.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(8.dp))
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = miniProjet.description,
                            fontFamily = acmeFont,
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            color = CustomColors.onBackground,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Les membres :",
                            fontFamily = acmeFont,
                            fontSize = 14.sp,
                            color = CustomColors.onPrimary,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        if(uiStateStudent.isLoading){
                            Loading(height = 250)
                        } else if(!uiStateStudent.error.isNullOrEmpty()){
                            ErrorComposable(error = uiStateStudent.error, height = 250)
                        } else {
                            studentlist.forEach { arrayStudent->
                                CardStudents(
                                    lastname = "${arrayStudent.get(0).lastname} ${arrayStudent.get(0).firstname}" ,
                                    classe = arrayStudent.get(0).classe
                                )
                            }
                        }
                       
                    }
                }
            }
        }

    }

}
