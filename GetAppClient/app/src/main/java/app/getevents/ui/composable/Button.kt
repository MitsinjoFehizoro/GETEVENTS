package app.getevents.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.white

@Composable
fun PrimaryButton(
    text : String,
    onClick : ()->Unit
){
    Box(
        Modifier
            .height(45.dp)
            .width(140.dp)
            .clickable { onClick() }
            .border(
                BorderStroke(1.dp, CustomColors.secondary),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = acmeFont,
            fontSize = 18.sp,
            color = CustomColors.secondary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SecondaryButton(
    text : String,
    onClick : ()->Unit
){
    Box(
        Modifier
            .height(45.dp)
            .width(140.dp)
            .clickable { onClick() }
            .background(
                color = CustomColors.secondary,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = acmeFont,
            fontSize = 18.sp,
            color = white,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PrimaryBtnAuth(
    text : String,
    isLoading : Boolean = false,
    onClick: () -> Unit = {}
){
    Box(
        Modifier
            .height(45.dp)
            .fillMaxWidth()
            .clickable { onClick() }
            .background(
                color = CustomColors.secondary,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        if(isLoading){
            Loading(height = 20)
        } else {
            Text(
                text = text,
                fontFamily = acmeFont,
                fontSize = 16.sp,
                color = white,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SecondaryBtnAuth(
    text : String,
    onClick: () -> Unit
){
    Box(
        Modifier
            .height(45.dp)
            .fillMaxWidth()
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = CustomColors.secondary,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = acmeFont,
            fontSize = 16.sp,
            color = CustomColors.secondary,
            textAlign = TextAlign.Center
        )
    }
}