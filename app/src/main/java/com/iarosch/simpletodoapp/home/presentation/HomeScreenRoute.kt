package com.iarosch.simpletodoapp.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun HomeScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToCreateTodoScreen: () -> Unit,
    navigateToUpdateTodo: (String) -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        uiState = uiState,
        onCreateTodoFloatingActionButtonClick = navigateToCreateTodoScreen,
        onDeleteTodoButtonClick = { viewModel.handleEvent(HomeScreenUiEvent.OnDeleteClick(it)) },
        onTodoClick = navigateToUpdateTodo
    )
}