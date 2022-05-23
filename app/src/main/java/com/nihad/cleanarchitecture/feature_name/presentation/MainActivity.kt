package com.nihad.cleanarchitecture.feature_name.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nihad.cleanarchitecture.feature_name.presentation.activityname.components.CompanyListScreen
import com.nihad.cleanarchitecture.feature_name.presentation.book_name.components.BookListScreen
import com.plcoding.cleanarchitecturenoteapp.ui.theme.CleanArchitectureNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{

            CleanArchitectureNoteAppTheme {
                androidx.compose.material.Surface(color= MaterialTheme.colors.background) {


                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.BookListScreen.route
                    ) {

                        composable(
                            route = Screen.CompanyListScreen.route
                        ) {
                            CompanyListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.BookListScreen.route
                        ) {
                            BookListScreen(navController = navController)
                        }

                    }
                }
            }
        }
    }
}