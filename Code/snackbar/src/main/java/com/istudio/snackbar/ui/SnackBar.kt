package com.istudio.snackbar.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.istudio.snackbar.state.SnackbarState
import com.istudio.snackbar.utils.SnackBarPosition


@Composable
fun SnackBar(
    messageBarState: SnackbarState,
    position: SnackBarPosition,
    visibilityDuration: Long,
    successIcon: ImageVector,
    errorIcon: ImageVector,
    errorMaxLines: Int,
    successMaxLines: Int,
    successContainerColor: Color,
    successContentColor: Color,
    errorContainerColor: Color,
    errorContentColor: Color,
    enterAnimation: EnterTransition,
    exitAnimation: ExitTransition,
    verticalPadding: Dp,
    horizontalPadding: Dp
) {

    var showMessageBar by remember { mutableStateOf(false) }



}