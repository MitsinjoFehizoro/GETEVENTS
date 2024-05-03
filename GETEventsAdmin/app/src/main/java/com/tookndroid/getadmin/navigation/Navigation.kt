package com.tookndroid.getadmin.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tookndroid.getadmin.models.Concoursprojet
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.Excursion
import com.tookndroid.getadmin.models.Reception
import com.tookndroid.getadmin.screens.ScreenAddModify
import com.tookndroid.getadmin.screens.ScreenEachEvent
import com.tookndroid.getadmin.screens.ScreenEvent
import com.tookndroid.getadmin.screens.ScreenHome
import com.tookndroid.getadmin.screens.ScreenSignUp
import com.tookndroid.getadmin.tools.TYPE_AFFICHER
import com.tookndroid.getadmin.ui.theme.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(mainViewModel: MainViewModel, navController: NavHostController) {


    NavHost(navController = navController, startDestination = Route.ScreenSignUp.itineraire) {

        composable(route = Route.ScreenSignUp.itineraire) {
            ScreenSignUp(navController, mainViewModel)
        }

        composable(route = Route.ScreenHome.itineraire) {
            ScreenHome(navController)
        }

        composable(
            route = Route.ScreenEvent.itineraire + "/{selectionnedItem}", arguments = listOf
                (navArgument("selectionnedItem") {
                type = NavType.IntType
            })
        ) {
            val selectionnedItem = it.arguments?.getInt("selectionnedItem")
            LaunchedEffect(Unit) {
                mainViewModel.getEvent()
            }
            ScreenEvent(mainViewModel, selectionnedItem, navController)
        }


        composable(
            route = Route.ScreenAddModify.itineraire + "/{isModify}",
            arguments = listOf(navArgument("isModify") {
                type = NavType.BoolType
            })
        ) {
            var isModify = it.arguments?.getBoolean("isModify")
            //manome event an'i screenAddModify
            ScreenAddModify(isModify, mainViewModel, navController)

        }

    }

}