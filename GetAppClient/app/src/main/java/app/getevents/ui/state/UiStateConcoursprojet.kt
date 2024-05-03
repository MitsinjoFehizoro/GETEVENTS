package app.getevents.ui.state

import app.getevents.models.ConcoursProjet

data class UiStateConcoursprojet(
    var isLoading: Boolean = true,
    val data: ConcoursProjet? = null,
    val error : String? = null
)
