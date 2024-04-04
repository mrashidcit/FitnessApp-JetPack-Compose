package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Black1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.BorderColor
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray2
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray3

@Composable
fun TopContainer(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        AppText(
            text = stringResource(id = R.string.hey_there),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            color = Black1,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(5.dp))
        AppText(
            text = stringResource(id = R.string.create_an_account),
            fontSize = 20.sp,
            lineHeight = 30.sp,
            color = Black1,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(30.dp))
        AppOutlinedTextField(
            value = "",
            onValueChange = { },
            placeholderText = stringResource(id = R.string.full_name),
            leadingIcon = R.drawable.ic_person_outlined,
            leadingIconOnClick = { }
        )
        Spacer(modifier = Modifier.height(15.dp))
        AppOutlinedTextField(
            value = "",
            onValueChange = { },
            placeholderText = stringResource(id = R.string.phone_number),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
            ),
            leadingIcon = R.drawable.ic_phone_outlined,
            leadingIconOnClick = { }
        )
        Spacer(modifier = Modifier.height(15.dp))
        AppOutlinedTextField(
            value = "",
            onValueChange = { },
            placeholderText = stringResource(id = R.string.email),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
            ),
            leadingIcon = R.drawable.ic_mail_outlined,
            leadingIconOnClick = { }
        )
        Spacer(modifier = Modifier.height(15.dp))
        AppOutlinedTextField(
            value = "",
            onValueChange = { },
            placeholderText = stringResource(id = R.string.password),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (true)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            leadingIcon = R.drawable.ic_lock_outlined,
            leadingIconOnClick = { },
            trailingIcon = R.drawable.ic_visibility_off_outlined,
            trailingIconOnClick = { },
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {

                },
                colors = CheckboxDefaults.colors().copy(
                    checkedBorderColor = Gray2,
                    uncheckedBorderColor = Gray2,
                )
            )
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                AppText(
                    text = buildAnnotatedString {
                        append(
                            stringResource(id = R.string.by_continuing_you_accept_our) + " "
                        )
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline,
                            )
                        ) {
                            append(stringResource(id = R.string.privacy_policy))
                        }
                        append(
                            " " + stringResource(id = R.string.and) + "\n"
                        )
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline,
                            )
                        ) {
                            append(
                                stringResource(id = R.string.term_of_use)
                            )
                        }
                    },
                    color = Gray2,
                    fontSize = 12.sp,
                    lineHeight = 15.sp,
                )
            }

        }


    }
}

@Composable
private fun AppOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String = "",
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
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Gray3,
                shape = RoundedCornerShape(14.dp),
            ),
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = Gray1,
                    modifier = Modifier
                        .size(18.dp)
                        .clickable {
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
                        .clickable {
                            trailingIconOnClick?.invoke()
                        }
                )
            }
        },
        placeholder = {
            AppText(
                text = placeholderText,
                color = Gray2,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 18.sp,
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

@Preview
@Composable
fun TopContainerPreview() {
    FitnessAppTheme {
        Surface(
            color = Color.White
        ) {
            TopContainer()
        }
    }
}

