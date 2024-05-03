package app.getevents.ui.state

import app.getevents.models.Student

data class UiStateStudent(
    var isLoading: Boolean = true,
    val data: Array<Student>? = null,
    val error: String? = null,

)
