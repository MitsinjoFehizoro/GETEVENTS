package com.tookndroid.getadmin.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.tookndroid.getadmin.component.CustomTimePicker
import com.tookndroid.getadmin.component.DeleteConfirmation
import com.tookndroid.getadmin.component.DescriptionTxtField
import com.tookndroid.getadmin.models.Programme
import com.tookndroid.getadmin.models.Reception
import com.tookndroid.getadmin.ui.theme.Blue500
import com.tookndroid.getadmin.ui.theme.Gray30
import com.tookndroid.getadmin.ui.theme.Gray50
import com.tookndroid.getadmin.ui.theme.Green1000
import com.tookndroid.getadmin.ui.theme.White10
import com.tookndroid.getadmin.ui.theme.White100

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAddReception(
    isModify: Boolean,
    event: Any?
) {
    if(isModify){
        event as Reception
        DescriptionTxtField(
            labelValue = "Participation",
            icon = Icons.Default.AttachMoney,
            event.participation
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ListAlt,
                contentDescription = "",
                modifier = Modifier.align(Alignment.CenterVertically),
                tint = White10
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Programmes",
                color = White10,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.weight(1F))
            Row(horizontalArrangement = Arrangement.End) {
                Surface(
                    modifier = Modifier.clip(RoundedCornerShape(50)),
                    color = Blue500,
                ) {
                    val isOpen = remember { mutableStateOf(false) }

                    IconButton(onClick = { isOpen.value = true }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add programm",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            tint = Color.White
                        )
                    }

                    if (isOpen.value) {

                        Dialog(onDismissRequest = { isOpen.value = false }) {
                            Surface(
                                color = Green1000,
                                modifier = Modifier.clip(RoundedCornerShape(10))
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(
                                        text = "Ajout d'un programme",
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp
                                        ),
                                        color = Gray30
                                    )
                                    DescriptionTxtField(
                                        labelValue = "Description du programme",
                                        icon = Icons.Default.TextFields, ""
                                    )
                                    CustomTimePicker(label = "Début", "")
                                    CustomTimePicker(label = "Fin", "")
                                    Row(modifier = Modifier.align(Alignment.End)) {
                                        TextButton(
                                            onClick = { isOpen.value = false },
                                        ) {
                                            Text(
                                                text = "Annuler",
                                                color = Gray30,
                                                style = TextStyle(fontWeight = FontWeight.Bold)
                                            )
                                        }
                                        TextButton(
                                            onClick = { isOpen.value = false },
                                        ) {
                                            Text(
                                                text = "Ajouter",
                                                color = Gray30,
                                                style = TextStyle(fontWeight = FontWeight.Bold)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        event.programmes.forEach {
            ProgrammeItem(programmeListData = it, onElementClick = {
                /*TO DO*/
            })
        }
    } else {
        DescriptionTxtField(
            labelValue = "Participation",
            icon = Icons.Default.AttachMoney,
            ""
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ListAlt,
                contentDescription = "",
                modifier = Modifier.align(Alignment.CenterVertically),
                tint = White10
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Programmes",
                color = White10,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.weight(1F))
            Row(horizontalArrangement = Arrangement.End) {
                Surface(
                    modifier = Modifier.clip(RoundedCornerShape(50)),
                    color = Blue500,
                ) {
                    val isOpen = remember { mutableStateOf(false) }

                    IconButton(onClick = { isOpen.value = true }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add programm",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            tint = Color.White
                        )
                    }

                    if (isOpen.value) {

                        Dialog(onDismissRequest = { isOpen.value = false }) {
                            Surface(
                                color = Green1000,
                                modifier = Modifier.clip(RoundedCornerShape(10))
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(
                                        text = "Ajout d'un programme",
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 20.sp
                                        ),
                                        color = Gray30
                                    )
                                    DescriptionTxtField(
                                        labelValue = "Description du programme",
                                        icon = Icons.Default.TextFields, ""
                                    )
                                    CustomTimePicker(label = "Début", "")
                                    CustomTimePicker(label = "Fin", "")
                                    Row(modifier = Modifier.align(Alignment.End)) {
                                        TextButton(
                                            onClick = { isOpen.value = false },
                                        ) {
                                            Text(
                                                text = "Annuler",
                                                color = Gray30,
                                                style = TextStyle(fontWeight = FontWeight.Bold)
                                            )
                                        }
                                        TextButton(
                                            onClick = { isOpen.value = false },
                                        ) {
                                            Text(
                                                text = "Ajouter",
                                                color = Gray30,
                                                style = TextStyle(fontWeight = FontWeight.Bold)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProgrammeItem(programmeListData: Programme, onElementClick: (Int) -> Unit) {
    Surface(
        color = White100,
        modifier = Modifier
            .padding(5.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(10))
            .fillMaxWidth()
            .clickable { onElementClick(programmeListData.id) }
    ) {
        Row(
            modifier = Modifier
                .padding(7.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Green1000)
            ) {
                Text(
                    text = "${programmeListData.id}",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.Center),
                    color = Gray30
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4F)
            ) {
                Text(
                    text = "${programmeListData.debut} à ${programmeListData.fin}",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = programmeListData.description,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                val shouldShowDialog = remember { mutableStateOf(false) }
                if (shouldShowDialog.value) {
                    DeleteConfirmation(
                        dialogTitle = "Confirmation",
                        dialogText = "Voulez-vous vraiment supprimer ce programme?",
                        shouldShowDialog = shouldShowDialog,
                    )
                }
                IconButton(
                    onClick = { shouldShowDialog.value = true },

                    ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Delete",
                        tint = Gray50
                    )
                }
            }
        }
    }
}