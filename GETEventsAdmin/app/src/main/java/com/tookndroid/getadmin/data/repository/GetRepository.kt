package com.tookndroid.getadmin.data.repository

import com.tookndroid.getadmin.tools.Resultat
import com.tookndroid.getadmin.data.api.GetApi
import com.tookndroid.getadmin.data.api.StudentGetApi
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.ConferenceResponse
import com.tookndroid.getadmin.models.NewConference
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class GetRepository @Inject constructor(
    private val api : GetApi
) {

    //GET
    suspend fun getEvenements() = flow {
        emit(Resultat.Loading())
        val evenements = api.getEvenements().body()?.data
        emit(Resultat.Success(evenements))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getConferences() = flow {
        emit(Resultat.Loading())
        val conferences = api.getConferences().body()?.data
        emit(Resultat.Success(conferences))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getReceptions() = flow {
        emit(Resultat.Loading())
        val programmes = api.getReceptions().body()?.data
        emit(Resultat.Success(programmes))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getExcursions() = flow {
        emit(Resultat.Loading())
        val activites = api.getExcursions().body()?.data
        emit(Resultat.Success(activites))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getConcoursprojets() = flow {
        emit(Resultat.Loading())
        val miniprojets = api.getConcoursprojets().body()?.data
        emit(Resultat.Success(miniprojets))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    //CREATE
    suspend fun createConference(conference : NewConference) = flow {
        emit(Resultat.Loading())
        val conferences = api.createConference(conference).body()?.data
        emit(Resultat.Success(conferences))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    //delete
    suspend fun deleteConference(conferenceId: Int): Response<Unit> {
        return api.deleteConference(conferenceId)
    }

    suspend fun deleteReception(receptionId: Int): Response<Unit> {
        return api.deleteReception(receptionId)
    }

    suspend fun deleteExcursion(excursionId: Int): Response<Unit> {
        return api.deleteExcursion(excursionId)
    }

    suspend fun deleteConcoursprojet(concoursprojetId: Int): Response<Unit> {
        return api.deleteConcoursprojet(concoursprojetId)
    }


    val retrofit = Retrofit.Builder()
        .baseUrl("https://flask-api-espa.onrender.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiStudent = retrofit.create(StudentGetApi::class.java)

    suspend fun getStudents(studentId : String) = flow {
        emit(Resultat.Loading())
        val students = apiStudent.getStudents(studentId).body()
        emit(Resultat.Success(students))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }
}