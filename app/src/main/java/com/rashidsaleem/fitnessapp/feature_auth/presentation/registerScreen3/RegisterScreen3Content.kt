package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray5
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.H4Bold
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.MediumTextSemiBold
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.SmallTextRegular
import com.rashidsaleem.fitnessapp.core.presentation.util.marginVertically

@Composable
fun RegisterScreen3Content() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        20.marginVertically()
        AppText(
            text = stringResource(R.string.what_is_your_goal),
            color = MaterialTheme.colorScheme.onBackground,
            style = H4Bold
        )
        5.marginVertically()
        AppText(
            text = stringResource(R.string.it_will_help_us_to_choose_a_best_program),
            color = Gray5,
            style = SmallTextRegular
        )
        20.marginVertically()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
//                .background(color = Color.Yellow)
                .background(
                    brush = Brush.
                )
                .clip(RoundedCornerShape(22.dp))
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.card_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(
//                        vertical = 20.dp
//                    ),
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.img_register3_person1),
//                    contentDescription = null,
//                )
//                20.marginVertically()
//                AppText(
//                    text = stringResource(R.string.improve_shape),
//                    color = Color.White,
//                    style = MediumTextSemiBold,
//                )
//                HorizontalDivider(
//                    modifier = Modifier.width(50.dp),
//                    color = Color.White
//                )
//                20.marginVertically()
//                AppText(
//                    text = stringResource(R.string.i_have_a_low_amount_of_body_fat_and_need),
//                    color = Color.White,
//                    style = SmallTextRegular,
//                )
//
//            }
        }


    }

}


@Preview
@Composable
private fun RegisterScreen3ContentPreview() {
    FitnessAppTheme {
        Surface {
            RegisterScreen3Content()
        }
    }
}