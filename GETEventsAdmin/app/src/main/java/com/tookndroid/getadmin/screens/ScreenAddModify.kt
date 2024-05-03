package com.tookndroid.getadmin.screens

//import androidx.compose.material.icons.filled.Abc
//import androidx.compose.material.icons.filled.AccessTime
//import androidx.compose.material.icons.filled.TextFields
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tookndroid.getadmin.component.Background
import com.tookndroid.getadmin.component.CustomDatePicker
import com.tookndroid.getadmin.component.CustomTimePicker
import com.tookndroid.getadmin.component.DescriptionTxtField
import com.tookndroid.getadmin.component.MyTextField
import com.tookndroid.getadmin.component.TopAddModify
import com.tookndroid.getadmin.models.Concoursprojet
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.Excursion
import com.tookndroid.getadmin.models.Reception
import com.tookndroid.getadmin.tools.TYPE_AFFICHER
import com.tookndroid.getadmin.ui.theme.MainViewModel

@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAddModify(
    isModify: Boolean?, mainViewModel: MainViewModel, navController: NavHostController
) {

    Scaffold(
        topBar = { TopAddModify(mainViewModel, navController, isModify) }
    ) {

        Box(modifier = Modifier) {
            Background(modifier = Modifier.matchParentSize())
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                if (isModify == true) {
                    var event: MutableState<Any?> = remember {
                        mutableStateOf(mainViewModel.uiState.value.data[0])
                    }
                    event.value = mainViewModel.uiState.value.currentData
                    if (event.value is Conference) {
                        Column(modifier = Modifier.padding(it)) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                displayTextField(true, event = event.value, 1)
                            }
                        }
                    } else if (event.value is Reception) {
                        Column(modifier = Modifier.padding(it)) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                displayTextField(true, event = event.value, 2)
                            }
                        }
                    } else if (event.value is Excursion) {
                        Column(modifier = Modifier.padding(it)) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                displayTextField(true, event = event.value, 3)
                            }
                        }
                    } else if (event.value is Concoursprojet) {
                        Column(modifier = Modifier.padding(it)) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                displayTextField(true, event = event.value, 4)
                            }
                        }
                    }
                } else {
                    when (mainViewModel.uiState.value.typeAfficher) {
                        TYPE_AFFICHER.CONFERENCE -> {
                            Column (modifier = Modifier.padding(it)){
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    displayTextField(isModify = false, event = null, idOfType = 1)
                                }
                            }
                        }
                        TYPE_AFFICHER.RECEPTION -> {
                            Column (modifier = Modifier.padding(it)){
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    displayTextField(isModify = false, event = null, idOfType = 2)
                                }
                            }
                        }
                        TYPE_AFFICHER.EXCURSION -> {
                            Column (modifier = Modifier.padding(it)){
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    displayTextField(isModify = false, event = null, idOfType = 3)
                                }
                            }
                        }
                        TYPE_AFFICHER.CONCOURSPROJET -> {
                            Column (modifier = Modifier.padding(it)){
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    displayTextField(isModify = false, event = null, idOfType = 4)
                                }
                            }
                        }
                        else -> {}
                    }

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun displayTextField(isModify: Boolean, event: Any?, idOfType: Int){
    if (isModify) {
        when (idOfType) {
            1 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, (event as
                            Conference).title
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, event.lieu
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, event.description
                )

                CustomDatePicker(event.date.substring(0, 9))
                CustomTimePicker(label = "Heure", event.date.substring(11,19))
                ScreenAddConference(true, event)

            }

            2 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, (event as
                            Reception).title
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, event.lieu
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, event.description
                )
                CustomDatePicker(event.date.substring(0, 9))
                CustomTimePicker(label = "Heure", event.date.substring(11,19))
                ScreenAddReception(true, event)
            }

            3 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, (event as
                            Excursion).title
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, event.lieu
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, event.description
                )
                CustomDatePicker(event.date.substring(0, 9))
                CustomTimePicker(label = "Heure", event.date.substring(11,19))
                ScreenAddExcursion(true, event)
            }

            4 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, (event as
                            Concoursprojet).title
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, event.lieu
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, event.description
                )
                CustomDatePicker(event.date.substring(0, 9))
                CustomTimePicker(label = "Heure", event.date.substring(11,19))
                ScreenAddConcoursProjet(true, event)
            }

        }
    } else {
        when (idOfType) {
            1 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, ""
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, ""
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, ""
                )
                CustomDatePicker("")
                CustomTimePicker(label = "Heure", "")
                ScreenAddConference(false, event = event)

            }

            2 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, ""
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, ""
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, ""
                )
                CustomDatePicker("")
                CustomTimePicker(label = "Heure", "")
                ScreenAddReception(false, event = event)
            }

            3 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, ""
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, ""
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, ""
                )
                CustomDatePicker("")
                CustomTimePicker(label = "Heure", "")
                ScreenAddExcursion(false, event = event)
            }

            4 -> {
                MyTextField(
                    labelValue = "Titre", icon = Icons.Default.List, ""
                )
                MyTextField(
                    labelValue = "Lieu", icon = Icons.Default
                        .Place, ""
                )

                DescriptionTxtField(
                    labelValue = "Description", icon =
                    Icons
                        .Default.Menu, ""
                )
                CustomDatePicker("")
                CustomTimePicker(label = "Heure", "")
                ScreenAddConcoursProjet(false, event = event)

            }
        }
    }
}


//@Preview
//@Composable
//fun ScreenAddModifyPreview() {
//    ScreenAddModify()
//}