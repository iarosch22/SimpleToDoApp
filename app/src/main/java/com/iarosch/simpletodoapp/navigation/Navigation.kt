package com.iarosch.simpletodoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.iarosch.simpletodoapp.create_and_update.presentation.navigation.CreateAndUpdateTodoResArg
import com.iarosch.simpletodoapp.create_and_update.presentation.navigation.createAndUpdateTodoScreen
import com.iarosch.simpletodoapp.create_and_update.presentation.navigation.navigateToCreateAndUpdateTodo
import com.iarosch.simpletodoapp.home.presentation.HOME_SCREEN_ROUTE
import com.iarosch.simpletodoapp.home.presentation.homeScreen
import com.iarosch.simpletodoapp.home.presentation.navigateToHomeScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME_SCREEN_ROUTE) {

        homeScreen(
            navigateToCreateTodoScreen = {
                navController.navigateToCreateAndUpdateTodo(CreateAndUpdateTodoResArg.CREATE_TODO,null)
            },
            navigateToUpdateTodo = {
                navController.navigateToCreateAndUpdateTodo(CreateAndUpdateTodoResArg.UPDATE_TODO, it)
            }
        )

        createAndUpdateTodoScreen { navController.navigateToHomeScreen() }
    }
}