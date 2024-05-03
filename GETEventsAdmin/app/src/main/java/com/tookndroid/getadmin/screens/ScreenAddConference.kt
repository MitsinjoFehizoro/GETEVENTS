package com.tookndroid.getadmin.screens

import android.os.Build
import android.telecom.Conference
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CrisisAlert
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.tookndroid.getadmin.component.DescriptionTxtField

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAddConference(isModify: Boolean, event: Any?) {
    if (isModify) {
        event as com.tookndroid.getadmin.models.Conference
        var intervenant = event.intervenant
        DescriptionTxtField(
            labelValue = "Intervenant",
            icon = Icons.Default.Groups,
            content = event.intervenant
        )
        DescriptionTxtField(
            labelValue = "Cible",
            icon = Icons.Default.CrisisAlert,
            content = event.cible
                .joinToString(separator = ", ")
        )
    } else {
        DescriptionTxtField(
            labelValue = "Intervenant",
            icon = Icons.Default.Groups,
            content = ""
        )
        DescriptionTxtField(
            labelValue = "Cible",
            icon = Icons.Default.CrisisAlert,
            content = ""
        )
    }
}