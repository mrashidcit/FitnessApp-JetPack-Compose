package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MenuDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppGradientButton
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Black1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray2
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray5
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.RegisterScreen2Action
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.RegisterScreen2UiState
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.RegisterScreen2ViewModel
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.previewRegisterScreen2UiState

@Composable
fun RegisterScreen2Content(
    uiState: RegisterScreen2UiState,
    action: (RegisterScreen2Action) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_register_complete_profile),
            contentDescription = null,
            )
        Spacer(modifier = Modifier.height(30.dp))
        AppText(
            text = stringResource(id = R.string.lets_complete_your_profile),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp,
            color = Black1
        )
        Spacer(modifier = Modifier.height(5.dp))
        AppText(
            text = stringResource(id = R.string.it_will_help_us_to_know_more_about_you),
            fontSize = 12.sp,
            lineHeight = 18.sp,
            color = Gray5,
        )
        Spacer(modifier = Modifier.height(30.dp))



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 50.dp)
            ,
        ) {
            InputFieldsContainer(
                uiState = uiState,
                action = action
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        AppGradientButton(
            text = stringResource(id = R.string.next).uppercase(),
            icon = R.drawable.ic_arrow_right,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
            ,
        ) {
            action(RegisterScreen2Action.NextOnClick)
        }
        Spacer(modifier = Modifier.height(40.dp))



    }
}





@Preview
@Composable
fun RegisterScreen2ContentPreview() {
    FitnessAppTheme {
        val uiState = previewRegisterScreen2UiState

        RegisterScreen2Content(
            uiState = uiState,
            action = { }
        )
    }
}

