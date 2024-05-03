package com.tookndroid.getadmin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tookndroid.getadmin.models.Activite
import com.tookndroid.getadmin.models.Excursion
import com.tookndroid.getadmin.ui.theme.Gray50

@Composable
fun ScreenExcursion(
    event : Excursion
) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
        Text(text = "Participation : ${event.participation}")
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Activités :",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            textAlign = TextAlign.Center
        )
        event.activites.forEach {
            AboutActivityItem(activityListData = it)
        }
    }
}

@Composable
fun AboutActivityItem(activityListData: Activite) {
    Surface(
        modifier = Modifier
            .padding(5.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(10))
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(7.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(15.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Gray50)
                    .align(Alignment.Top)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = activityListData.title,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    softWrap = true,
                )
                Text(
                    text = activityListData.description,
                    softWrap = true,
                )
            }
        }
    }
}