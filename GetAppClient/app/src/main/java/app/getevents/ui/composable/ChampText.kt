package app.getevents.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import app.getevents.ui.theme.CustomColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChampText(value : MutableState<String>, placeholder : String){
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
    ) {
        val(box) = createRefs()
        TextField(
            value = value.value,
            onValueChange = { value.value = it },
            textStyle = LocalTextStyle.current.copy(
                fontSize = 16.sp,
                color = CustomColors.onDark,
            ) ,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    color = CustomColors.onDark,
                    fontSize = 16.sp
                )
            },
        )
        Box (
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(
                    color = CustomColors.onDark
                )
                .constrainAs(box) {
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
}
