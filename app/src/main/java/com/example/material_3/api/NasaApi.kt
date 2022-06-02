package com.example.materiallesson.api

import com.example.material_3.api.EPICResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("planetary/apod")
    suspend fun getNasaPicture(
       @Query("api_key") key: String
    ): PictureOfTheDayResponse

    @GET("api/natural")
    suspend fun getEpicPicture() : ArrayList<EPICResponseItem>

}