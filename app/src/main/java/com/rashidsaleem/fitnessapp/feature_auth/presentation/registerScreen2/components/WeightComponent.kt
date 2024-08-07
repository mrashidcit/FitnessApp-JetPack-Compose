package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppOutlinedTextField
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.components.AppTextDefaults
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.PurpleLinear

@Composable
fun WeightComponent(
    value: String = "",
    onValueChange: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppOutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .weight(1f),
            singleLine = true,
            isError = false,
            placeholderText = stringResource(id = R.string.your_weight),
            leadingIcon = R.drawable.ic_weight,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next,
            )
        )
        Spacer(modifier = Modifier.width(15.dp))
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = PurpleLinear
                    )
                )
        ) {
            AppText(
                text = stringResource(id = R.string.kg).uppercase(),
                modifier = Modifier.align(Alignment.Center),
                textFont = AppTextDefaults.textFont.copy(
                    size = 12.sp,
                    weight = FontWeight.Medium,
                ),
                textLineInfo = AppTextDefaults.textLineInfo.copy(
                    lineHeight = 18.sp,
                ),
                color = Color.White,
            )
        }

    }
}