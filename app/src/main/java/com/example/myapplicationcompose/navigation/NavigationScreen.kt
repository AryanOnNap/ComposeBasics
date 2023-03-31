package com.example.myapplicationcompose.navigation

import com.example.myapplicationcompose.DiagramBox

sealed class NavigationScreen(val route : String){
    object diagramBox : NavigationScreen ("DiagramBox")
    object calenderView : NavigationScreen ("CalenderView")
}
