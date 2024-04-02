package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Blue1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.LogoLinear

@Composable
fun FabWithProgressBar(
    modifier: Modifier = Modifier,
    progressValue: Float,
    onClick: () -> Unit,
) {

    Box(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = LogoLinear
                    ),
                    shape = CircleShape
                )
                .clickable { onClick() }
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = Color.White,
            )

        }


        CircularProgressIndicator(
            progress = progressValue,
            modifier = Modifier.size(60.dp),
            color = Blue1,
            strokeWidth = 2.dp,
            strokeCap = StrokeCap.Round,
        )
    }


}

@Preview
@Composable
fun FabWithProgressBarPreview() {
    FitnessAppTheme {
        Surface(
            color = Color.White,
        ) {
            FabWithProgressBar(
                progressValue = 0.25f,
                onClick = { }
            )
        }
    }
}

