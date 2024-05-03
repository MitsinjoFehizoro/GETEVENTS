package com.tookndroid.getadmin.state

import android.os.Build
import androidx.annotation.RequiresApi
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.NewConference
import java.time.LocalDateTime

data class UiStateConference @RequiresApi(Build.VERSION_CODES.O) constructor(
    val isLoading : Boolean = true,
    val data : NewConference? = NewConference(
        title = "Conférence Toky",
        description = "Une description",
        date = "2024-04-15T18:27:54",
//        date = LocalDateTime.parse("2024-04-15T18:27:54"),
        lieu = "Vontovorona",
        intervenant = "Mr Ando",
        cible = arrayOf("L1", "L2"),
        updatedAt = LocalDateTime.parse("2024-04-15T18:27:54"),
        createdAt = LocalDateTime.parse("2024-04-15T18:27:54"),
        id = 1,
        EvenementId = 7
    ),
    val error : String? = null
)
