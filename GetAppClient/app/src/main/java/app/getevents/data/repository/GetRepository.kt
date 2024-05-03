package app.getevents.data.repository

import app.getevents.data.api.GetApi
import app.getevents.data.api.StudentApi
import app.getevents.tools.Resultat
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class GetRepository @Inject constructor(
    private val api : GetApi,
) {

    suspend fun getEvenements() = flow {
        emit(Resultat.Loading())
        val evenements = mutableListOf<Any>()

        val conferences = api.getConferences().body()?.data
        val excursions = api.getExcursions().body()?.data
        val receptions = api.getReceptions().body()?.data
        val concoursProjets = api.getConcoursProjets().body()?.data

        conferences?.forEach{
            evenements.add(it)
        }
        excursions?.forEach{
            evenements.add(it)
        }
        receptions?.forEach{
            evenements.add(it)
        }
        concoursProjets?.forEach {
            evenements.add(it)
        }

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

    suspend fun getConferenceByPk(id : Int) = flow {
        emit(Resultat.Loading())
        val conference = api.getConferenceByPk(id).body()?.data
        emit(Resultat.Success(conference))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getConcoursProjets() = flow {
        emit(Resultat.Loading())
        val concoursProjets = api.getConcoursProjets().body()?.data
        emit(Resultat.Success(concoursProjets))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getConcoursProjetByPk(id : Int) = flow {
        emit(Resultat.Loading())
        val concoursProjet = api.getConcoursProjetsByPk(id).body()?.data
        emit(Resultat.Success(concoursProjet))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getMiniProjetByPk(id : Int) = flow {
        emit(Resultat.Loading())
        val miniProjet = api.getMiniProjetByPk(id).body()?.data
        emit(Resultat.Success(miniProjet))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getExcursions() = flow {
        emit(Resultat.Loading())
        val excursions = api.getExcursions().body()?.data
        emit(Resultat.Success(excursions))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getExcursionByPk(id : Int) = flow {
        emit(Resultat.Loading())
        val excursion = api.getExcursionByPk(id).body()?.data
        emit(Resultat.Success(excursion))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getReceptions() = flow {
        emit(Resultat.Loading())
        val receptions = api.getReceptions().body()?.data
        emit(Resultat.Success(receptions))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getReceptionByPk(id : Int) = flow {
        emit(Resultat.Loading())
        val reception = api.getReceptionByPk(id).body()?.data
        emit(Resultat.Success(reception))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    val retrofit = Retrofit.Builder()
        .baseUrl("https://flask-api-espa.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiStudent = retrofit.create(StudentApi::class.java)


    suspend fun getStudentByPk(id : String) = flow {
        emit(Resultat.Loading())
        val student = apiStudent.getStudentByPk(id).body()
        emit(Resultat.Success(student))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

    suspend fun getUser(numero : String) = flow {
        emit(Resultat.Loading())
        val user = api.getUser(numero).body()?.data
        emit(Resultat.Success(user))
    }.catch { error->
        emit(Resultat.Error(error.message))
    }

}