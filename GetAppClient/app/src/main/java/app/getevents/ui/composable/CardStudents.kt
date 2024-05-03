package app.getevents.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.getevents.ui.theme.CustomColors
import app.getevents.ui.theme.acmeFont


@Composable
fun CardStudents(
    lastname : String,
    classe : String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
            .background(
                color = CustomColors.background,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .padding(4.dp)
                .size(45.dp)
        ) {
            Box(
                Modifier
                    .size(45.dp)
                    .background(
                        color = CustomColors.onWhite,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = classe,
                    fontFamily = acmeFont,
                    fontSize = 16.sp,
                    color = CustomColors.secondary,
                )
            }
        }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = lastname,
                fontFamily = acmeFont,
                fontSize = 12.sp,
                color = CustomColors.onBackground,
                overflow = TextOverflow.Ellipsis,
                softWrap = false
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}