package com.rashidsaleem.fitnessapp.core.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.poppinsFontFamily

data class TextFont(
    val weight: FontWeight = FontWeight.Normal,
    val family: FontFamily? = poppinsFontFamily,
    val size: TextUnit = TextUnit.Unspecified,
)

data class TextLineInfo(
    val maxLines: Int = Int.MAX_VALUE,
    val lineHeight: TextUnit = TextUnit.Unspecified,
)

@Immutable
object AppTextDefaults {
    val textFont: TextFont = TextFont()
    val textLineInfo = TextLineInfo()
}

@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textFont: TextFont = AppTextDefaults.textFont,
    overflow: TextOverflow = TextOverflow.Clip,
    textLineInfo: TextLineInfo = AppTextDefaults.textLineInfo,
    textAlign: TextAlign? = null,
) {

    Text(
        text = text,
        modifier = modifier,
        fontFamily = textFont.family,
        fontWeight = textFont.weight,
        fontSize = textFont.size,
        color = color,
        lineHeight = textLineInfo.lineHeight,
        maxLines = textLineInfo.maxLines,
        textAlign = textAlign,
        overflow = overflow,
    )

}

@Composable
fun AppText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textFont: TextFont = AppTextDefaults.textFont,
    textLineInfo: TextLineInfo = AppTextDefaults.textLineInfo,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign? = null,
) {

    Text(
        text = text,
        modifier = modifier,
        fontFamily = textFont.family,
        fontWeight = textFont.weight,
        fontSize = textFont.size,
        color = color,
        lineHeight = textLineInfo.lineHeight,
        maxLines = textLineInfo.maxLines,
        textAlign = textAlign,
        overflow = overflow,
    )

}

