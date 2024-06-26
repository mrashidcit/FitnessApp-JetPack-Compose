package com.rashidsaleem.fitnessapp.core.presentation.components

import android.text.SpannableStringBuilder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.core.text.buildSpannedString
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Gray1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.poppinsFontFamily

@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily? = poppinsFontFamily,
    fontSize: TextUnit = TextUnit.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
) {

    Text(
        text = text,
        modifier = modifier,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        lineHeight = lineHeight,
        textAlign = textAlign,
    )

}

@Composable
fun AppText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily? = poppinsFontFamily,
    fontSize: TextUnit = TextUnit.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
) {

    Text(
        text = text,
        modifier = modifier,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        lineHeight = lineHeight,
        textAlign = textAlign,
    )

}

