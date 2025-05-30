package com.iarosch.simpletodoapp.core.ui_kit

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.iarosch.simpletodoapp.ui.theme.SimpleToDoAppTheme

@Composable
fun TodoTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeHolderText: String,
    singleLine: Boolean = false,
    placeholderTextColor: Color = MaterialTheme.colorScheme.secondary,
    textColor: Color = MaterialTheme.colorScheme.primary,
    disabledBorderColor: Color = MaterialTheme.colorScheme.primary,
    unfocusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeHolderText,
                color = placeholderTextColor
            )
        },
        singleLine = singleLine,
        textStyle = TextStyle(textColor),
        shape = OutlinedTextFieldDefaults.shape,
        colors = OutlinedTextFieldDefaults.colors(
            disabledBorderColor = disabledBorderColor,
            unfocusedBorderColor = unfocusedBorderColor,
            focusedBorderColor = focusedBorderColor
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTodoTitleTextField() {
    SimpleToDoAppTheme (dynamicColor = false) {
        TodoTextField(
            text = "Text text text",
            placeHolderText = "Title",
            onValueChange = {}
        )
    }
}
