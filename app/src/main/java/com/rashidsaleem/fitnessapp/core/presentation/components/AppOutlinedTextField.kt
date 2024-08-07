package com.rashidsaleem.fitnessapp.core.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.BorderColor
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray2
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray3

@Composable
fun AppOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    placeholderText: String = "",
    singleLine: Boolean = false,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    @DrawableRes leadingIcon: Int? = null,
    leadingIconOnClick: (() -> Unit)? = null,
    @DrawableRes trailingIcon: Int? = null,
    trailingIconOnClick: (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .background(
                color = Gray3,
                shape = RoundedCornerShape(14.dp),
            ),
        singleLine = singleLine,
        isError = isError,
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = Gray1,
                    modifier = Modifier
                        .size(18.dp)
                        .clickable(
                            enabled = (leadingIconOnClick != null)
                        ) {
                            leadingIconOnClick?.invoke()
                        }
                )
            }
        },
        trailingIcon = {
            trailingIcon?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = Gray1,
                    modifier = Modifier
                        .size(18.dp)
                        .clickable(
                            enabled = (trailingIconOnClick != null)
                        ) {
                            trailingIconOnClick?.invoke()
                        }
                )
            }
        },
        placeholder = {
            AppText(
                text = placeholderText,
                color = Gray2,
                textFont = AppTextDefaults.textFont.copy(
                    size = 12.sp,
                    weight = FontWeight.Normal,
                ),
                textLineInfo = AppTextDefaults.textLineInfo.copy(
                    lineHeight = 18.sp,
                )
            )
        },
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = BorderColor,
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
    )
}