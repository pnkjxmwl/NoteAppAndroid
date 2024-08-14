package com.example.noteappyt.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.noteappyt.features.favourites.presentation.FavouritesScreen
import com.example.noteappyt.navigation.Screen
import com.example.noteappyt.navigation.Tab

fun NavGraphBuilder.favorites(navController: NavController){
    navigation(
        startDestination = Screen.FavoritesScreen.route,
        route = Tab.Favorites.route
    ){
        composable(route = Screen.FavoritesScreen.route){
            FavouritesScreen(onEditNoteClick ={
                noteId ->
                navController.navigate(
                    route= "${Screen.AddEditNoteScreen.route}/$noteId"
                )
            } , navController =navController )
        }
    }
}