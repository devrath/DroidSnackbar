package com.istudio.snackbar.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.istudio.snackbar.utils.TestTags.MESSAGE_BAR
import com.istudio.snackbar.utils.TestTags.MESSAGE_BAR_TEXT

@Composable
internal fun SnackBarContent(
    modifier: Modifier = Modifier,
    message: String?, error: String?,
    successIcon: ImageVector, errorIcon: ImageVector,
    errorMaxLines: Int, successMaxLines: Int,
    successContainerColor: Color, successContentColor: Color,
    errorContainerColor: Color, errorContentColor: Color,
    verticalPadding: Dp, horizontalPadding: Dp
) {
    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxWidth() // Stretch to full width of screen
            .background(
                // Fill the background with a color
                determineContainerColor(error, errorContainerColor, successContainerColor)
            )
            .padding(vertical = verticalPadding) // Setting vertical padding
            .padding(horizontal = horizontalPadding) // Setting horizontal padding padding
            .animateContentSize()// Perform a animation
            .testTag(MESSAGE_BAR),// This is for testing
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier.weight(4f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = determineIcon(error, errorIcon, successIcon),
                contentDescription = "Message Bar Icon",
                tint = determineContentColor(error, errorContentColor, successContentColor)
            )
            Spacer(modifier = modifier.width(12.dp))
            Text(
                modifier = modifier.testTag(tag = MESSAGE_BAR_TEXT),
                text = message ?: (error ?: "Unknown"),
                color = determineContentColor(error, errorContentColor, successContentColor),
                fontSize = MaterialTheme.typography.labelLarge.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = determineNumberOfLines(error, errorMaxLines, successMaxLines)
            )
        }

    }
}

@Composable
@Preview
internal fun MessageBarPreview() {
    SnackBarContent(
        message = "Successfully Updated.",
        error = null,
        successIcon = Icons.Default.Check,
        errorIcon = Icons.Default.Warning,
        successMaxLines = 1,
        errorMaxLines = 1,
        successContainerColor = MaterialTheme.colorScheme.primaryContainer,
        successContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        errorContainerColor = MaterialTheme.colorScheme.errorContainer,
        errorContentColor = MaterialTheme.colorScheme.onErrorContainer,
        verticalPadding = 12.dp,
        horizontalPadding = 12.dp
    )
}