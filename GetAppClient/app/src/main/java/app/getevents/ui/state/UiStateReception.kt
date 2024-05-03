package app.getevents.ui.state

import app.getevents.models.Reception

data class UiStateReception(
    var isLoading: Boolean = true,
    val data: Reception? = null,
    val error : String? = null
)
