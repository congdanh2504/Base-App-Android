package com.congdanh.baseapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.congdanh.feature.addnote.AddNoteScreen
import com.congdanh.feature.addnote.AddNoteViewModel
import com.congdanh.feature.home.HomeScreen
import com.congdanh.feature.home.HomeViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(route = Routes.HOME) {
            val viewModel: HomeViewModel = hiltViewModel()
            val notes by viewModel.notes.collectAsStateWithLifecycle()
            HomeScreen(notes) {
                navController.navigate(Routes.ADD_NOTE)
            }
        }
        composable(route = Routes.ADD_NOTE) {
            val viewModel: AddNoteViewModel = hiltViewModel()

            AddNoteScreen {
                viewModel.addNote(it)
                navController.popBackStack()
            }
        }
    }
}
