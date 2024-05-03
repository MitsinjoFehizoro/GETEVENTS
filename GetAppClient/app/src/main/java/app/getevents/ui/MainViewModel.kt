package app.getevents.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.getevents.data.repository.GetRepository
import app.getevents.models.Student
import app.getevents.tools.Resultat
import app.getevents.tools.TYPE_AFFICHER
import app.getevents.ui.state.UiStateConcoursprojet
import app.getevents.ui.state.UiStateConference
import app.getevents.ui.state.UiStateEvent
import app.getevents.ui.state.UiStateExcursion
import app.getevents.ui.state.UiStateFooterActive
import app.getevents.ui.state.UiStateMenuActive
import app.getevents.ui.state.UiStateMiniProjet
import app.getevents.ui.state.UiStateReception
import app.getevents.ui.state.UiStateStudent
import app.getevents.ui.state.UiStateUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GetRepository,
) : ViewModel() {

    val uiStateEvent = mutableStateOf(UiStateEvent())
    val uiStateConference = mutableStateOf(UiStateConference())
    val uiStateConcoursprojet = mutableStateOf(UiStateConcoursprojet())
    val uiStateMiniProjet = mutableStateOf(UiStateMiniProjet())
    val uiStateStudent = mutableStateOf(UiStateStudent())
    val uiStateExcursion = mutableStateOf(UiStateExcursion())
    val uiStateReception = mutableStateOf(UiStateReception())
    val uiStateUser = mutableStateOf(UiStateUser())

    val uiStateMenuActive = mutableStateOf(UiStateMenuActive())
    val uiStateFooterActive = mutableStateOf(UiStateFooterActive())
    val studentList = mutableListOf<Array<Student>>()

    init {

    }

    fun getEvent(){
        viewModelScope.launch {
            when(uiStateEvent.value.typeAfficher){
                TYPE_AFFICHER.EVENEMENT->{
                    repository.getEvenements().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                    }
                }
                TYPE_AFFICHER.CONFERENCE->{
                    repository.getConferences().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Conferences"
                        )
                    }

                }
                TYPE_AFFICHER.CONCOURS_PROJET->{
                    repository.getConcoursProjets().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Concours mini-projets"
                        )
                    }
                }
                TYPE_AFFICHER.EXCURSION->{
                    repository.getExcursions().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Excursions"
                        )
                    }
                }
                TYPE_AFFICHER.RECEPTION->{
                    repository.getReceptions().collect{resultat->
                        when (resultat){
                            is Resultat.Loading->{
                                uiStateEvent.value = UiStateEvent(isLoading = true)
                            }
                            is Resultat.Success->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, data = resultat.data!!)
                            }
                            is Resultat.Error->{
                                uiStateEvent.value = UiStateEvent(isLoading = false, error = resultat.message)
                            }
                        }
                        uiStateEvent.value = uiStateEvent.value.copy(
                            sousTitre = "Receptions"
                        )
                    }
                }
            }

        }
    }

    fun getConferenceByPk(id : Int){
        viewModelScope.launch {
            repository.getConferenceByPk(id).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateConference.value = UiStateConference(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateConference.value = UiStateConference(isLoading = false, data = resultat.data)
                    }
                    is Resultat.Error->{
                        uiStateConference.value = UiStateConference(isLoading = false, error = resultat.message)
                    }
                }

            }
        }
    }

    fun getConcoursProjetByPk(id : Int){
        viewModelScope.launch {
            repository.getConcoursProjetByPk(id).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateConcoursprojet.value = UiStateConcoursprojet(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateConcoursprojet.value = UiStateConcoursprojet(isLoading = false, data = resultat.data)
                    }
                    is Resultat.Error->{
                        uiStateConcoursprojet.value = UiStateConcoursprojet(isLoading = false, error = resultat.message)
                    }
                }
            }
        }
    }

    fun getMiniProjetByPk(id : Int){
        viewModelScope.launch {
            repository.getMiniProjetByPk(id).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateMiniProjet.value = UiStateMiniProjet(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateMiniProjet.value = UiStateMiniProjet(isLoading = false, data = resultat.data)
                    }
                    is Resultat.Error->{
                        uiStateMiniProjet.value = UiStateMiniProjet(isLoading = false, error = resultat.message)
                    }
                }
            }
        }
    }

    fun getExcursionByPk(id : Int){
        viewModelScope.launch {
            repository.getExcursionByPk(id).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateExcursion.value = UiStateExcursion(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateExcursion.value = UiStateExcursion(isLoading = false, data = resultat.data)
                    }
                    is Resultat.Error->{
                        uiStateExcursion.value = UiStateExcursion(isLoading = false, error = resultat.message)
                    }
                }
            }
        }
    }

    fun getReceptionByPk(id : Int){
        viewModelScope.launch {
            repository.getReceptionByPk(id).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateReception.value = UiStateReception(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateReception.value = UiStateReception(isLoading = false, data = resultat.data)
                    }
                    is Resultat.Error->{
                        uiStateReception.value = UiStateReception(isLoading = false, error = resultat.message)
                    }
                }
            }
        }
    }

    fun getStudentByPk(id : String){
        viewModelScope.launch {
            repository.getStudentByPk(id).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateStudent.value = UiStateStudent(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateStudent.value = UiStateStudent(isLoading = false, data = resultat.data!!)
                        studentList.add(resultat.data)
                    }
                    is Resultat.Error->{
                        uiStateStudent.value = UiStateStudent(isLoading = false, error = resultat.message)
                    }
                }
            }
        }
    }

    fun getUser(numero : String){
        viewModelScope.launch {
            repository.getUser(numero).collect{resultat->
                when(resultat){
                    is Resultat.Loading->{
                        uiStateUser.value = UiStateUser(isLoading = true)
                    }
                    is Resultat.Success->{
                        uiStateUser.value = UiStateUser(isLoading = false, data = resultat.data!!)
                    }
                    is Resultat.Error->{
                        uiStateUser.value = UiStateUser(isLoading = false, error = resultat.message)
                    }
                }
            }
        }
    }

    fun switchTypeAfficher(tp : TYPE_AFFICHER, state : UiStateMenuActive){
        uiStateMenuActive.value = state
        uiStateEvent.value = uiStateEvent.value.copy(
            typeAfficher = tp
        )
        getEvent()
    }

    fun switchFooterActive(state : UiStateFooterActive){
        uiStateFooterActive.value = state
    }
}