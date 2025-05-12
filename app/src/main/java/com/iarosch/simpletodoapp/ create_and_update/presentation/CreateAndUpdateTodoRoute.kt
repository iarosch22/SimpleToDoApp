package com.iarosch.simpletodoapp.create_and_update.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun CreateAndUpdateTodoRoute(
    modifier: Modifier = Modifier,
    viewModel: CreateAndUpdateTodoViewModel = hiltViewModel(),
    topBarTitle: Int?,
    navigateToHomeScreen: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CreateAndUpdateNoteScreen(
        modifier = modifier,
        uiState = uiState,
        topBarTitle = topBarTitle,
        onSaveButtonClick = { viewModel.handleEvent(CreateAndUpdateTodoUiEvent.OnSaveClicked) },
        navigateToHomeScreen = navigateToHomeScreen,
        onTitleChanged = { viewModel.handleEvent(CreateAndUpdateTodoUiEvent.OnTitleChanged(it)) },
        onDescriptionChanged = { viewModel.handleEvent(CreateAndUpdateTodoUiEvent.OnDescriptionChanged(it)) }
    )
}