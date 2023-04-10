package com.example.myapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.CalenderView
import com.example.myapplicationcompose.DiagramBox
import com.example.myapplicationcompose.util.ErrorUtils


@Composable
    fun StartNavigation(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = NavigationScreen.diagramBox.route){
            composable(NavigationScreen.diagramBox.route){
            DiagramBox().Greetings(str = "Hello",navController)


            }
            composable(NavigationScreen.calenderView.route + "/{colorTheme}"){
                val theme : String? = it.arguments?.getString("colorTheme")
                if (theme != null) {
                    CalenderView().calender(color = theme)
                }
                ErrorUtils.showLogs("StartNavigation","CalenderView"+theme);
            }
        }
    }




