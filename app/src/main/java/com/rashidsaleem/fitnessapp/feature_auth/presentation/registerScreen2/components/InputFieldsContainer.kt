@file:OptIn(ExperimentalMaterial3Api::class)

package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import com.rashidsaleem.fitnessapp.core.common.util.DateTimeUtil
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.BorderColor
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray2
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray4
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray5
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.RegisterScreen2Action
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.RegisterScreen2UiState
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.previewRegisterScreen2UiState
import java.util.Date


@Composable
fun InputFieldsContainer(
    uiState: RegisterScreen2UiState,
    action: (RegisterScreen2Action) -> Unit,
) {

    var showGenderMenu by remember {
        mutableStateOf(false)
    }

    // Choose Gender
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(
                    color = BorderColor,
                )
                .clickable {
                    showGenderMenu = true
                }
                .padding(
                    vertical = 15.dp,
                    horizontal = 15.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_person_group),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = Gray5
            )
            Spacer(modifier = Modifier.width(10.dp))
            AppText(
                modifier = Modifier.weight(1f),
                text = uiState.getGenderLabel(),
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Gray2,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = Gray2
            )
        }

        DropdownMenu(
            expanded = showGenderMenu,
            onDismissRequest = { showGenderMenu = false },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp)),
            properties = PopupProperties(focusable = true),
        ) {
            DropdownMenuItem(
                text = {
                    AppText(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.male),
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = Gray2,
                    )
                },
                onClick = {
                    showGenderMenu = false
                    action(RegisterScreen2Action.SetGender(GenderEnum.Male))
                },
                colors = MenuDefaults.itemColors().copy(
                    textColor = Color.Black,
                ),
                modifier = Modifier
                    .background(
                        color = if (uiState.gender == GenderEnum.Male) Gray4 else Color.White
                    )
            )
            DropdownMenuItem(
                text = {
                    AppText(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.female),
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = Gray2,
                    )
                },
                onClick = {
                    showGenderMenu = false
                    action(RegisterScreen2Action.SetGender(GenderEnum.Female))
                },
                modifier = Modifier
                    .background(
                        color = if (uiState.gender == GenderEnum.Female) Gray4 else Color.White
                    )
            )
            DropdownMenuItem(
                text = {
                    AppText(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.other),
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = Gray2,
                    )
                },
                onClick = {
                    showGenderMenu = false
                    action(RegisterScreen2Action.SetGender(GenderEnum.Other))
                },
                modifier = Modifier
                    .background(
                        color = if (uiState.gender == GenderEnum.Other) Gray4 else Color.White
                    )
            )

        }
    }

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    // Date of Birth
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(
                color = BorderColor,
            )
            .clickable {
                showDatePicker = true
            }
            .padding(
                vertical = 15.dp,
                horizontal = 15.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = Gray5
        )
        Spacer(modifier = Modifier.width(10.dp))
        AppText(
            modifier = Modifier.weight(1f),
            text = if (uiState.dateOfBirth == null)
                stringResource(id = R.string.date_of_birth)
            else
                DateTimeUtil.toString(uiState.dateOfBirth),
            fontSize = 12.sp,
            lineHeight = 18.sp,
            color = Gray2,
        )
    }

    val datePickerState = rememberDatePickerState(
        initialDisplayMode = DisplayMode.Input,
    )
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            dismissButton = {
                Text(
                    text = stringResource(id = R.string.cancel),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable {
                            showDatePicker = false
                        }
                        .padding(12.dp),
                    color = Color.Red,
                )
            },
            confirmButton = {
                Text(
                    text = stringResource(id = R.string.confirm),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable {
                            datePickerState
                                .selectedDateMillis
                                ?.let {
                                    val date = Date(it);
                                    action(RegisterScreen2Action.SetDateOfBirth(date))
                                }
                            showDatePicker = false
                        }
                        .padding(12.dp)
                )
            },
        ) {
            DatePicker(
                state = datePickerState,
//                modifier = Modifier.padding(16.dp),
                modifier = Modifier,
                title = null,
            )
        }
    }

    Spacer(modifier = Modifier.height(15.dp))
    WeightComponent(
        value = uiState.weight,
        onValueChange = {
            action(RegisterScreen2Action.SetWeight(it))
        }
    )

    Spacer(modifier = Modifier.height(15.dp))
    HeightComponent(
        value = uiState.height,
        onValueChange = {
            action(RegisterScreen2Action.SetHeight(it))
        }
    )
}

@Preview
@Composable
private fun InputFieldsContainerPreview() {
    FitnessAppTheme {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {

            val uiState = remember {
                previewRegisterScreen2UiState
            }

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                InputFieldsContainer(
                    uiState = uiState,
                    action = {}
                )
            }
        }
    }
}



