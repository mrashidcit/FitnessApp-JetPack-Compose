package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.components.AppText
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.BorderColor
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray2
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray5


@Composable
fun InputFieldsContainer() {
    // Choose Gender
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(
                color = BorderColor,
            )
            .clickable { }
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
            text = stringResource(id = R.string.choose_gender),
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

    // Date of Birth
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(
                color = BorderColor,
            )
            .clickable { }
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
            text = stringResource(id = R.string.date_of_birth),
            fontSize = 12.sp,
            lineHeight = 18.sp,
            color = Gray2,
        )
    }

    // Your Weight
    val weightValue = rememberSaveable {
        mutableStateOf("")
    }
    Spacer(modifier = Modifier.height(15.dp))
    WeightComponent(
        value = weightValue.value,
        onValueChange = { weightValue.value = it }
    )

    // Your Height
    val heightValue = rememberSaveable {
        mutableStateOf("")
    }
    Spacer(modifier = Modifier.height(15.dp))
    HeightComponent(
        value = heightValue.value,
        onValueChange = { heightValue.value = it }
    )
}



