package com.example.material_3.domain

import com.example.material_3.BuildConfig
import com.example.material_3.api.EPICResponseItem
import com.example.materiallesson.api.NasaApi
import com.example.materiallesson.api.PictureOfTheDayResponse
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NasaRepositoryImpl : NasaRepository {

    val gson = GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create()

    private val apiPictureOfTheDay = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NasaApi::class.java)


    private val apiEpicPicture = Retrofit.Builder()
        .baseUrl("https://epic.gsfc.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(NasaApi::class.java)



    override suspend fun getNasaPictureOfTheDay(): PictureOfTheDayResponse =
        apiPictureOfTheDay.getNasaPicture(BuildConfig.NASA_API_KEY)


    override suspend fun getEPICPicture(): ArrayList<EPICResponseItem> =
         apiEpicPicture.getEpicPicture()

}