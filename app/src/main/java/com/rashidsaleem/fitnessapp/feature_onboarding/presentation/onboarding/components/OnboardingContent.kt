package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Black1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray1
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.OnboardingEvent
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.OnboardingUiState
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.previewOnboardingUiState

@Composable
fun OnboardingContent(
    uiState: OnboardingUiState,
    onEvent: (OnboardingEvent) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
//            Box(modifier = Modifier.weight(0.5f)) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = uiState.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
//            }
            Spacer(modifier = Modifier.height(64.dp))
            AppText(
                modifier = Modifier.padding(horizontal = 30.dp),
                text = stringResource(id = uiState.title),
                color = Black1,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 36.sp,
            )
            Spacer(modifier = Modifier.height(15.dp))
            AppText(
                modifier = Modifier.padding(horizontal = 30.dp),
                text = stringResource(id = uiState.description),
                color = Gray1,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 21.sp,
            )
        }

        FabWithProgressBar(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 30.dp,
                    bottom = 40.dp,
                ),
            progressValue = uiState.progressValue,
            onClick = { onEvent(OnboardingEvent.MoveNext) }
        )
    }
}

@Preview
@Composable
fun OnboardingContentPreview() {
    FitnessAppTheme {
        Surface {
            val uiState = previewOnboardingUiState.copy(
                progressValue = 0.25f
            )

            OnboardingContent(
                uiState = uiState,
                onEvent = { }
            )
        }
    }
}

