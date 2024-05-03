package com.tookndroid.getadmin.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tookndroid.getadmin.data.repository.GetRepository
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.NewConference
import com.tookndroid.getadmin.state.UiStateAuthentification
import com.tookndroid.getadmin.state.UiStateConference
import com.tookndroid.getadmin.state.UiStateStudent
import com.tookndroid.getadmin.tools.Resultat
import com.tookndroid.getadmin.tools.TYPE_AFFICHER
import com.tookndroid.getadmin.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: GetRepository,
    //val studentRepository : StudentGetRepository
) : ViewModel() {

    var uiState = mutableStateOf(UiState())
    val uiStateConference = mutableStateOf(UiStateConference())
    val uiStateStudent = mutableStateOf(UiStateStudent())
    var uiStateAuthentification = mutableStateOf(UiStateAuthentification())

    init {
        getEvent()
    }

    //asina condition when
    fun getEvent() {
        viewModelScope.launch { ->
            when (uiState.value.typeAfficher) {
                TYPE_AFFICHER.EVENEMENT -> {
                    repository.getEvenements().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }

                TYPE_AFFICHER.CONFERENCE -> {
                    repository.getConferences().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }

                }

                TYPE_AFFICHER.RECEPTION -> {
                    repository.getReceptions().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }

                TYPE_AFFICHER.EXCURSION -> {
                    repository.getExcursions().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }

                TYPE_AFFICHER.CONCOURSPROJET -> {
                    repository.getConcoursprojets().collect { resultat ->
                        when (resultat) {
                            is Resultat.Loading -> {
                                uiState.value = UiState(isLoading = true)
                            }

                            is Resultat.Success -> {
                                uiState.value = UiState(isLoading = false, data = resultat.data!!)
                            }

                            is Resultat.Error -> {
                                uiState.value = UiState(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createConference(conference : NewConference) {
        viewModelScope.launch {
            repository.createConference(conference).collect {
                when(it) {
                    is Resultat.Loading -> {
                        uiStateConference.value = UiStateConference(isLoading = true)
                    }

                    is Resultat.Success -> {
                        uiStateConference.value = UiStateConference(isLoading = false, data = it.data)
                    }

                    is Resultat.Error -> {
                        uiStateConference.value = UiStateConference(isLoading = false, error = it.message)
                    }
                    else -> {}
                }
            }
        }
    }
    fun deleteConference(conferenceId: Int) {
        viewModelScope.launch {
            val response = repository.deleteConference(conferenceId)
            if (response.isSuccessful) {

            } else {

            }
        }
    }
    fun deleteReception(receptionId: Int) {
        viewModelScope.launch {
            val response = repository.deleteReception(receptionId)
            if (response.isSuccessful) {

            } else {

            }
        }
    }
    fun deleteExcursion(excursionId: Int) {
        viewModelScope.launch {
            val response = repository.deleteExcursion(excursionId)
            if (response.isSuccessful) {

            } else {

            }
        }
    }
    fun deleteConcoursprojet(concoursprojetId : Int) {
        viewModelScope.launch {
            val response = repository.deleteConcoursprojet(concoursprojetId)
            if (response.isSuccessful) {

            } else {

            }
        }
    }
    fun getStudents(studentId : String) {
        viewModelScope.launch {
            repository.getStudents(studentId).collect { resultat ->
                when (resultat) {
                    is Resultat.Loading -> {
                        uiStateStudent.value = UiStateStudent(isLoading = true)
                    }

                    is Resultat.Success -> {
                        uiStateStudent.value = UiStateStudent(isLoading = false, data = resultat.data)
                    }

                    is Resultat.Error -> {
                        uiStateStudent.value = UiStateStudent(isLoading = false, error = resultat.message)
                    }
                }
            }
        }
    }



}