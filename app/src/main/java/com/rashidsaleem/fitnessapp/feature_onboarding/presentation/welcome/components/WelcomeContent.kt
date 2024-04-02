package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppGradientButton
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.PurpleLinear
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.poppinsFontFamily
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome.WelcomeEvent
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome.WelcomeScreenEnum
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome.WelcomeScreenUiState
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome.previewWelcomeScreenUiState

@Composable
fun WelcomeContent(
    uiState: WelcomeScreenUiState,
    onEvent: (WelcomeEvent) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
            brush = Brush.horizontalGradient(
                colors = uiState.backgroundColor
            )
        )

    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.height(54.dp),
                painter = painterResource(id = uiState.logoImage),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(id = R.string.everybody_can_train),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = Gray1
            )
        }

        AppGradientButton(
            text = stringResource(id = R.string.get_started),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp)
                .padding(horizontal = 30.dp),
            onClick = { onEvent(WelcomeEvent.GetStarted) }
        )

    }
}

@Preview
@Composable
fun WelcomeContentPreview() {
    FitnessAppTheme {
        Surface {
            val uiState = remember{
                previewWelcomeScreenUiState
            }
            WelcomeContent(
                uiState = uiState,
                onEvent = {}
                )
        }
    }
}

