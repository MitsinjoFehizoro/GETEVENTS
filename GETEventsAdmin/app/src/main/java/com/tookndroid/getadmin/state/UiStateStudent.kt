package com.tookndroid.getadmin.state

import com.tookndroid.getadmin.models.Student

data class UiStateStudent(
    val isLoading : Boolean = true,
    val data : Array<Student>? = null,
    val error : String? = null
)
