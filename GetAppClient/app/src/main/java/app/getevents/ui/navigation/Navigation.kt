package app.getevents.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.getevents.ui.screen.AttendScreen
import app.getevents.ui.screen.ConcoursScreen
import app.getevents.ui.screen.ConferenceScreen
import app.getevents.ui.screen.EventScreen
import app.getevents.ui.screen.ExcursionScreen
import app.getevents.ui.screen.HomeScreen
import app.getevents.ui.screen.LoginScreen
import app.getevents.ui.screen.MiniScreen
import app.getevents.ui.screen.ReceptionScreen
import app.getevents.ui.screen.SignUpScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.HomeScreen.itineraire){
        composable(route = Route.HomeScreen.itineraire){
            HomeScreen(navController = navController)
        }

        composable(route = Route.EventScreen.itineraire){
            EventScreen(navController)
        }

        composable(
            route = "${Route.ConferenceScreen.itineraire}/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            ConferenceScreen(id = it.arguments?.getInt("id")!!, navController = navController)
        }

        composable(
            route = "${Route.ConcoursScreen.itineraire}/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            ConcoursScreen(id = it.arguments?.getInt("id")!!, navController = navController)
        }

        composable(
            route = "${Route.MiniScreen.itineraire}/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ) {
            MiniScreen(id = it.arguments?.getInt("id")!!, navController = navController)
        }

        composable(
            route = "${Route.ExcursionScreen.itineraire}/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            ExcursionScreen(id = it.arguments?.getInt("id")!!, navController = navController)
        }

        composable(
            route = "${Route.ReceptionScreen.itineraire}/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            ReceptionScreen(id = it.arguments?.getInt("id")!!, navController = navController)
        }

        composable(route = Route.LoginScreen.itineraire){
            LoginScreen(navController = navController)
        }

        composable(route = Route.SignUpScreen.itineraire){
            SignUpScreen(navController = navController)
        }

        composable(route = Route.AttendScreen.itineraire){
            AttendScreen(navController)
        }

    }
}