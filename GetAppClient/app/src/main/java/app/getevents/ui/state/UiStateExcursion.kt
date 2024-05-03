package app.getevents.ui.state

import app.getevents.models.Excursion

data class UiStateExcursion(
    var isLoading: Boolean = true,
    val data: Excursion? = null,
    val error : String? = null
)
