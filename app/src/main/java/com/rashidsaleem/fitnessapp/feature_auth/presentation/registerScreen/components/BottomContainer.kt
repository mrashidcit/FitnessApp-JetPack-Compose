package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppGradientButton
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Black1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray4
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Purple1
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen.RegisterEvent

@Composable
fun BottomContainer(
    modifier: Modifier = Modifier,
    onEvent: (RegisterEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AppGradientButton(
            text = stringResource(id = R.string.register),
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                onEvent(RegisterEvent.RegisterOnClick)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Gray4,
            )
            AppText(
                text = stringResource(id = R.string.or),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Black1,
            )
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Gray4,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconBox(
                icon = R.drawable.ic_google,
                onClick = {
                    onEvent(RegisterEvent.LoginWithGoogleOnClick)
                }
            )
            Spacer(modifier = Modifier.width(30.dp))
            IconBox(
                icon = R.drawable.ic_facebook,
                onClick = {
                    onEvent(RegisterEvent.LoginWithFacebookOnClick)
                }
            )

        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            AppText(
                text = stringResource(id = R.string.already_have_an_account),
                fontSize = 14.sp,
                lineHeight = 21.sp,
                color = Black1,
            )
            Spacer(modifier = Modifier.width(4.dp))
            AppText(
                text = stringResource(id = R.string.login),
                modifier = Modifier.clickable {
                    onEvent(RegisterEvent.LoginOnClick)
                },
                fontSize = 14.sp,
                lineHeight = 21.sp,
                color = Purple1,
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
private fun IconBox(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(
                shape = RoundedCornerShape(14.dp)
            )
            .border(
                width = 1.dp,
                color = Gray4,
                shape = RoundedCornerShape(14.dp)
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Preview
@Composable
fun BottomContainerPreview() {
    FitnessAppTheme {
        Surface(
            color = Color.White,
        ) {


            BottomContainer(
                onEvent = {}
            )
        }
    }
}

