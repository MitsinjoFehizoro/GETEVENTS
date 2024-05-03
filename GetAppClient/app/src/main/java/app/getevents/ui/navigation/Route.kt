package app.getevents.ui.navigation

sealed class Route (
    val itineraire : String
) {
    object HomeScreen : Route("home_screen")
    object EventScreen : Route("event_screen")
    object ConferenceScreen : Route("conference_screen")
    object AttendScreen : Route("attend_screen")
    object ConcoursScreen : Route("concours_screen")
    object MiniScreen : Route("mini_screen")
    object ExcursionScreen : Route("excursion_screen")
    object ReceptionScreen : Route("reception_screen")
    object LoginScreen : Route("login_screen")
    object SignUpScreen : Route("signup_screen")
}