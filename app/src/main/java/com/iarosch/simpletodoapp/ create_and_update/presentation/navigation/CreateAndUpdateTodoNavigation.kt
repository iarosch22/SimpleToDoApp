package com.iarosch.simpletodoapp.create_and_update.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.iarosch.simpletodoapp.R
import com.iarosch.simpletodoapp.create_and_update.presentation.CreateAndUpdateTodoRoute

const val CREATE_AND_UPDATE_TODO_ROUTE = "create_and_update_todo_route"
const val TODO_ID_ARG = "todo_id"
const val TOP_BAR_TITLE_ARG = "top_bar_title"


enum class CreateAndUpdateTodoResArg {
    CREATE_TODO, UPDATE_TODO
}

fun NavController.navigateToCreateAndUpdateTodo(
    topBarTitleResArg: CreateAndUpdateTodoResArg,
    noteId: String?
) {
    val topBarTitleResId = when(topBarTitleResArg) {
        CreateAndUpdateTodoResArg.CREATE_TODO -> R.string.create_todo_topbar_title
        CreateAndUpdateTodoResArg.UPDATE_TODO -> R.string.update_todo_topbar_title
    }
    navigate(
        route = "$CREATE_AND_UPDATE_TODO_ROUTE/$topBarTitleResId/$noteId",
    ) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.createAndUpdateTodoScreen(navigateToHomeScreen: () -> Unit) {
    composable(
        route = "$CREATE_AND_UPDATE_TODO_ROUTE/{$TOP_BAR_TITLE_ARG}/{$TODO_ID_ARG}",
        arguments = listOf(
            navArgument(TODO_ID_ARG) { type = NavType.StringType; nullable = true },
            navArgument(TOP_BAR_TITLE_ARG) { type = NavType.IntType }
        )
    ) { backStackEntry ->
        CreateAndUpdateTodoRoute(
            topBarTitle = backStackEntry.arguments?.getInt(TOP_BAR_TITLE_ARG),
            navigateToHomeScreen = navigateToHomeScreen
        )
    }
}