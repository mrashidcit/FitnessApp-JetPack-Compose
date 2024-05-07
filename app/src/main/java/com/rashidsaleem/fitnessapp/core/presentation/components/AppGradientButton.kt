package com.rashidsaleem.fitnessapp.core.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Blue1
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.LogoLinear
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.Purple2
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.poppinsFontFamily

@Composable
fun AppGradientButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes icon: Int? = null,
    colors: List<Color> = LogoLinear,
    height: Dp = 60.dp,
    shape: Shape = RoundedCornerShape(99.dp),
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .height(height)
            .background(
                brush = Brush.horizontalGradient(
                    colors = colors
                ),
                shape = shape
            )
            .clip(shape)
            .clickable { onClick() }
        ,
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center),
           verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = text,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                lineHeight = 24.sp,
            )
            icon?.let {
                Spacer(modifier = Modifier.width(3.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.White,
                )
            }

        }
    }
}

@Preview
@Composable
fun AppGradientButtonPreview() {
    FitnessAppTheme {
        FitnessAppTheme {

            Column(
                modifier = Modifier
                    .background(Color.Green)
            ) {

                AppGradientButton(
                    text = stringResource(id = R.string.get_started),
                    modifier = Modifier
                        .fillMaxWidth(),
                    icon = R.drawable.ic_arrow_right,
                ) {

                }

            }

        }
    }
}