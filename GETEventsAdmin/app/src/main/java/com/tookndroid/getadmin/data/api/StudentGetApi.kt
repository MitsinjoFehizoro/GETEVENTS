package com.tookndroid.getadmin.data.api

import com.tookndroid.getadmin.models.Student
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentGetApi {
    @GET("/student/{studentId}")
    suspend fun getStudents(@Path("studentId") studentId : String) : Response<Array<Student>>
}