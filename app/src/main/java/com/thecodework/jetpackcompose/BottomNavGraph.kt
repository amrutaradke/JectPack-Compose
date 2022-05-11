package com.thecodework.jetpackcompose

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@ExperimentalMaterialApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
  NavHost(navController = navController,
           startDestination = BottomBarScreen.Home.route  ){
       composable(route = BottomBarScreen.Home.route){
         HomeScreen()
       }
    composable(route = BottomBarScreen.Profile.route){
      ProfileActivity()

    }
    composable(route = BottomBarScreen.Favorite.route){
      //SuperScriptText(normalText = "Hello", superText = "World!")
      //SubScriptText(normalText = "Amruta",  superText = "Radke" )
     // FavoriteAcivity()
//      ExpandableCardWithAni(
//        title = "My Title",
//        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
//            "sed do eiusmod tempor incididunt ut labore et dolore magna " +
//            "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
//            "ullamco laboris nisi ut aliquip ex ea commodo consequat."
//      )
      CustomComponent()

    }
  }
}