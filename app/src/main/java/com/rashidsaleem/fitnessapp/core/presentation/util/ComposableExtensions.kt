package com.rashidsaleem.fitnessapp.core.presentation.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Int.marginVertically() = Box(modifier = Modifier.height(this.dp))

@Composable
fun Int.marginHorizontally() = Box(modifier = Modifier.width(this.dp))
