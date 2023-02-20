package com.istudio.snackbar.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.istudio.snackbar.utils.Constants
import com.istudio.snackbar.utils.SnackBarPosition

@Composable
internal fun determineAnimationExit(position: SnackBarPosition) =
    shrinkVertically(
        animationSpec = tween(durationMillis = Constants.durationOfAnimation),
        shrinkTowards = if (position == SnackBarPosition.TOP)
            Alignment.Top else Alignment.Bottom
    )

@Composable
internal fun determineAnimationEntry(position: SnackBarPosition) =
    expandVertically(
        animationSpec = tween(durationMillis = Constants.durationOfAnimation),
        expandFrom = if (position == SnackBarPosition.TOP)
            Alignment.Top else Alignment.Bottom
    )


@Composable
internal fun determineNumberOfLines(
    error: String?, errorMaxLines: Int, successMaxLines: Int
) = if (error != null) errorMaxLines else successMaxLines

@Composable
internal fun determineIcon(
    error: String?, errorIcon: ImageVector, successIcon: ImageVector
) = if (error != null) errorIcon else successIcon

@Composable
internal fun determineContainerColor(
    error: String?, errorContainerColor: Color, successContainerColor: Color
) = if (error != null) errorContainerColor else successContainerColor

@Composable
internal fun determineContentColor(
    error: String?, errorContentColor: Color, successContentColor: Color
) = if (error != null) errorContentColor else successContentColor
