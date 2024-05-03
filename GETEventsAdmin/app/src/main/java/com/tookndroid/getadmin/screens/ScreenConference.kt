package com.tookndroid.getadmin.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tookndroid.getadmin.models.*

@Composable
fun ScreenConference(event : Conference) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
        Text(text = "Intervenant : ${event.intervenant}")
        Text(text = "Cibles : ${event.cible.joinToString ( separator = ", ")}")
    }
}