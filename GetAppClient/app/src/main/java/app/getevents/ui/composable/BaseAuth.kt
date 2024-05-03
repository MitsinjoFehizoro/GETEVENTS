package app.getevents.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import app.getevents.R
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont
import app.getevents.ui.theme.white

@Composable
fun BaseAuth(
    navController: NavController,
    content : @Composable () -> Unit
){
    ConstraintLayout(
        Modifier
            .fillMaxSize()
    ){
        val (box , button) = createRefs()

        BaseStyle()

        Column(
            Modifier
                .fillMaxSize()
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
                    .background(
                        color = CustomColors.background,
                        shape = RoundedCornerShape(bottomEnd = 80.dp)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(Modifier.height(30.dp)){}
                var src =  R.drawable.lightlogo
                if (isSystemInDarkTheme()) src = R.drawable.darklogo
                Image(
                    painter = painterResource(id = src),
                    contentDescription = null,
                    Modifier.size(220.dp)
                )

            }

            Column (
                Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
                    .background(
                        color = CustomColors.primary,
                        shape = RoundedCornerShape(topStart = 80.dp)
                    ),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .height(110.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "\"La fierté d'appartenance vient du coeur.\"",
                        fontFamily = acmeFont,
                        fontSize = 18.sp,
                        color = white,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Column(
            Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .fillMaxHeight(.53f)
                .background(
                    color = CustomColors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .constrainAs(box) {
                    bottom.linkTo(parent.bottom, margin = 80.dp)
                }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(
                        color = CustomColors.onWhite,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(22.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                content()
            }
        }

        Box(
            Modifier.constrainAs(button){
                top.linkTo(parent.top)
            }
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = CustomColors.primary)
            }
        }
    }
}