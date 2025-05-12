package com.iarosch.simpletodoapp.home.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val HOME_SCREEN_ROUTE = "home_screen"

fun NavController.navigateToHomeScreen() = navigate(HOME_SCREEN_ROUTE) {
    popUpTo(HOME_SCREEN_ROUTE) {
        inclusive = true
    }
}

fun NavGraphBuilder.homeScreen(
    navigateToCreateTodoScreen: () -> Unit,
    navigateToUpdateTodo: (String) -> Unit
) {
    composable(route = HOME_SCREEN_ROUTE) {
        HomeScreenRoute(
            navigateToCreateTodoScreen = navigateToCreateTodoScreen,
            navigateToUpdateTodo = navigateToUpdateTodo
        )
    }
}