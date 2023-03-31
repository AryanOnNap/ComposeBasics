package com.example.myapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.DiagramBox

class StartNavigation {

    @Composable
    fun startNavigation(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavigationScreen.diagramBox.route){
            composable(NavigationScreen.diagramBox.route){
DiagramBox().Greetings(str = "Hello",navController)
DiagramBox().MyPreview(navController)

            }
            composable(NavigationScreen.calenderView.route){

            }
        }
    }



}