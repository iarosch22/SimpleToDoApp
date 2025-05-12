package com.iarosch.simpletodoapp.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iarosch.simpletodoapp.R
import com.iarosch.simpletodoapp.core.domain.model.Todo
import com.iarosch.simpletodoapp.core.ui_kit.CreateTodoFloatingActionButton
import com.iarosch.simpletodoapp.core.ui_kit.ToDoTopBar
import com.iarosch.simpletodoapp.core.ui_kit.TodoItem

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState,
    onCreateTodoFloatingActionButtonClick: () -> Unit,
    onDeleteTodoButtonClick: (Todo) -> Unit,
    onTodoClick: (String) -> Unit
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ToDoTopBar(
                modifier = Modifier.shadow(4.dp),
                title = stringResource(R.string.todo_main_topbar_title)
            )
        },
        floatingActionButton = {
            CreateTodoFloatingActionButton {
                onCreateTodoFloatingActionButtonClick()
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when(uiState) {

                is HomeScreenUiState.Empty -> HomeScreenEmpty()

                is HomeScreenUiState.Content -> HomeScreenContent(
                    todoList = uiState.todoList,
                    onDeleteTodoButtonClick = onDeleteTodoButtonClick,
                    onTodoClick = onTodoClick
                )
            }
        }
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    todoList: List<Todo>,
    onDeleteTodoButtonClick: (Todo) -> Unit,
    onTodoClick: (String) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(todoList) { index, note ->
            Spacer(modifier = Modifier.height(20.dp))
            TodoItem(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .clickable { onTodoClick(note.id.toString()) },
                title = note.title,
                description = note.description,
                onDeleteButtonClick = { onDeleteTodoButtonClick(note) }
            )
        }
    }
}

@Composable
private fun HomeScreenEmpty(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.dont_have_any_todo_banner),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 27.sp,
            textAlign = TextAlign.Center,
        )
    }
}