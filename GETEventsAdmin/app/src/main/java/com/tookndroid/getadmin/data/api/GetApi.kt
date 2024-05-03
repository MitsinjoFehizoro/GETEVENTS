package com.tookndroid.getadmin.data.api


import com.tookndroid.getadmin.models.ConcoursprojetsResponse
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.ConferenceResponse
import com.tookndroid.getadmin.models.ConferencesResponse
import com.tookndroid.getadmin.models.EvenementsResponse
import com.tookndroid.getadmin.models.ExcursionsResponse
import com.tookndroid.getadmin.models.NewConference
import com.tookndroid.getadmin.models.ReceptionsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface GetApi {
    //GET
    @GET("/get/evenements/")
    suspend fun getEvenements(): Response<EvenementsResponse>

    @GET("/get/conferences/")
    suspend fun getConferences(): Response<ConferencesResponse>

    @GET("/get/receptions/")
    suspend fun getReceptions(): Response<ReceptionsResponse>

    @GET("/get/excursions/")
    suspend fun getExcursions(): Response<ExcursionsResponse>

    @GET("/get/concours-projets/")
    suspend fun getConcoursprojets(): Response<ConcoursprojetsResponse>


    //POST
    @POST("/get/conferences/")
    suspend fun createConference(
        @Body conference: NewConference
    ): Response<ConferenceResponse>

    @POST("/get/receptions")
    suspend fun setReceptions(): Response<ReceptionsResponse>

    @POST("/get/excursions/")
    suspend fun setExcursions(): Response<ExcursionsResponse>

    @POST("/get/concours-projets/")
    suspend fun setConcoursprojets(): Response<ConcoursprojetsResponse>

    //DELETE
    @DELETE("/get/conferences/{conferenceId}")
    suspend fun deleteConference(
        @Path("conferenceId") conferenceId: Int
    ) : Response<Unit>

    @DELETE("/get/receptions/{receptionId}")
    suspend fun deleteReception(
        @Path("receptionId") receptionId: Int
    ) : Response<Unit>

    @DELETE("/get/excursions/{excursionId}")
    suspend fun deleteExcursion(
        @Path("excursionId") excursionId: Int
    ) : Response<Unit>

    @DELETE("/get/concours-projets/{concoursprojetId}")
    suspend fun deleteConcoursprojet(
        @Path("concoursprojetId") concoursprojetId: Int
    ) : Response<Unit>

}
