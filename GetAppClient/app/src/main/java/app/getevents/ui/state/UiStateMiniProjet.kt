package app.getevents.ui.state

import app.getevents.models.MiniProjet

data class UiStateMiniProjet(
    var isLoading: Boolean = true,
    val data: MiniProjet? = null,
    val error : String? = null
)
