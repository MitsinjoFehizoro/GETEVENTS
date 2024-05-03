package com.tookndroid.getadmin.models

import java.time.LocalDate
import java.time.LocalDateTime

data class NewConference(
    var id: Int,
    var title: String,
    var lieu: String,
    var description: String,
    var date: String,
    var intervenant: String,
    var cible: Array<String>,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var EvenementId: Int
)
