package app.getevents.data.api

import app.getevents.models.Student
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentApi {
    @GET("/student/{id}")
    suspend fun getStudentByPk(@Path("id") id : String) : Response<Array<Student>>
}