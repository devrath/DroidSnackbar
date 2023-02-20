package com.istudio.snackbar.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Constants {
    val defaultPosition : SnackBarPosition = SnackBarPosition.TOP
    const val defaultVisibilityDuration : Long = 3500L
    val defaultSuccessIcon: ImageVector = Icons.Default.Check
    val defaultErrorIcon: ImageVector = Icons.Default.Warning
    const val defaultErrorMaxLines: Int = 1
    const val defaultSuccessMaxLines: Int = 1
    const val durationOfAnimation: Int = 300
    val defaultVerticalPadding: Dp = 12.dp
    val defaultHorizontalPadding: Dp = 12.dp
}

@Composable
internal fun defaultErrorContentColor() = MaterialTheme.colorScheme.onErrorContainer

@Composable
internal fun defaultErrorContainerColor() = MaterialTheme.colorScheme.errorContainer

@Composable
internal fun defaultSccessContentColor() = MaterialTheme.colorScheme.onPrimaryContainer

@Composable
internal fun defaultSuccessContainerColor() = MaterialTheme.colorScheme.primaryContainer

@Composable
internal fun defaultContentBackgroundColor() = MaterialTheme.colorScheme.surface