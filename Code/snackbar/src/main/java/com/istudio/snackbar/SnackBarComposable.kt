package com.istudio.snackbar

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.istudio.snackbar.state.SnackbarState
import com.istudio.snackbar.ui.SnackBar
import com.istudio.snackbar.ui.determineAnimationEntry
import com.istudio.snackbar.ui.determineAnimationExit
import com.istudio.snackbar.utils.Constants.defaultErrorIcon
import com.istudio.snackbar.utils.Constants.defaultErrorMaxLines
import com.istudio.snackbar.utils.Constants.defaultHorizontalPadding
import com.istudio.snackbar.utils.Constants.defaultPosition
import com.istudio.snackbar.utils.Constants.defaultSuccessIcon
import com.istudio.snackbar.utils.Constants.defaultSuccessMaxLines
import com.istudio.snackbar.utils.Constants.defaultVerticalPadding
import com.istudio.snackbar.utils.Constants.defaultVisibilityDuration
import com.istudio.snackbar.utils.Constants.durationOfAnimation
import com.istudio.snackbar.utils.SnackBarPosition
import com.istudio.snackbar.utils.defaultContentBackgroundColor
import com.istudio.snackbar.utils.defaultErrorContainerColor
import com.istudio.snackbar.utils.defaultErrorContentColor
import com.istudio.snackbar.utils.defaultSccessContentColor
import com.istudio.snackbar.utils.defaultSuccessContainerColor

@Composable
internal fun SnackBarComposable(
    modifier: Modifier = Modifier,
    state : SnackbarState,
    position : SnackBarPosition = defaultPosition,
    visibilityDuration : Long = defaultVisibilityDuration,
    successIcon: ImageVector = defaultSuccessIcon,
    errorIcon: ImageVector = defaultErrorIcon,
    errorMaxLines: Int = defaultErrorMaxLines,
    successMaxLines: Int = defaultSuccessMaxLines,
    contentBackgroundColor: Color = defaultContentBackgroundColor(),
    successContainerColor: Color = defaultSuccessContainerColor(),
    successContentColor: Color = defaultSccessContentColor(),
    errorContainerColor: Color = defaultErrorContainerColor(),
    errorContentColor: Color = defaultErrorContentColor(),
    enterAnimation: EnterTransition = determineAnimationEntry(position),
    exitAnimation: ExitTransition = determineAnimationExit(position),
    verticalPadding: Dp = defaultVerticalPadding,
    horizontalPadding: Dp = defaultHorizontalPadding,
    content: @Composable () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = contentBackgroundColor)
    ) {
        content()
        SnackBar(
            messageBarState = state,
            position = position,
            visibilityDuration = visibilityDuration,
            successIcon = successIcon,
            errorIcon = errorIcon,
            errorMaxLines = errorMaxLines,
            successMaxLines = successMaxLines,
            successContainerColor = successContainerColor,
            successContentColor = successContentColor,
            errorContainerColor = errorContainerColor,
            errorContentColor = errorContentColor,
            enterAnimation = enterAnimation,
            exitAnimation = exitAnimation,
            verticalPadding = verticalPadding,
            horizontalPadding = horizontalPadding
        )
    }
}