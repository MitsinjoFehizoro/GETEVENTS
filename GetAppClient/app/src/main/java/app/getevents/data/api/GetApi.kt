package app.getevents.data.api

import app.getevents.models.ConcoursProjetResponse
import app.getevents.models.ConcoursProjetsResponse
import app.getevents.models.ConferenceResponse
import app.getevents.models.ConferencesResponse
import app.getevents.models.ExcursionResponse
import app.getevents.models.ExcursionsResponse
import app.getevents.models.MiniProjetResponse
import app.getevents.models.ReceptionResponse
import app.getevents.models.ReceptionsResponse
import app.getevents.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GetApi {
    @GET("/get/conferences/")
    suspend fun getConferences () : Response<ConferencesResponse>

    @GET("/get/conferences/{id}")
    suspend fun getConferenceByPk(@Path("id") id : Int) : Response<ConferenceResponse>

    @GET("/get/concours-projets")
    suspend fun getConcoursProjets() : Response<ConcoursProjetsResponse>

    @GET("/get/concours-projets/{id}")
    suspend fun getConcoursProjetsByPk(@Path("id") id : Int) : Response<ConcoursProjetResponse>

    @GET("/get/mini-projets/{id}")
    suspend fun getMiniProjetByPk(@Path("id") id : Int) : Response<MiniProjetResponse>

    @GET("/get/excursions")
    suspend fun getExcursions() : Response<ExcursionsResponse>

    @GET("/get/excursions/{id}")
    suspend fun getExcursionByPk(@Path("id") id : Int) : Response<ExcursionResponse>

    @GET("/get/receptions")
    suspend fun getReceptions() : Response<ReceptionsResponse>

    @GET("/get/receptions/{id}")
    suspend fun getReceptionByPk(@Path("id") id : Int): Response<ReceptionResponse>

    @GET("/get/users/{numero}")
    suspend fun getUser(@Path("numero") numero : String) : Response<UserResponse>
}