package com.istudio.snackbar.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun rememberSnackBarState(): SnackbarState {
    return remember { SnackbarState() }
}

class SnackbarState {

    var success by mutableStateOf<String?>(null)
        private set

    var error by mutableStateOf<Exception?>(null)
        private set

    private var updated by mutableStateOf(false)

    fun addSuccess(message:String){
        error = null
        success = message
        updated = !updated
    }

    fun addError(exception: Exception) {
        success = null
        error = exception
        updated = !updated
    }

}