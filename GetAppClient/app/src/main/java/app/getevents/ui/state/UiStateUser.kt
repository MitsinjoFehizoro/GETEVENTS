package app.getevents.ui.state

import app.getevents.models.User

data class UiStateUser(
    val isLoading : Boolean = true,
    val data : User? = null,
    val error : String? = null
)
