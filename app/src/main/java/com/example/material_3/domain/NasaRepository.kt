package com.example.material_3.domain

import com.example.material_3.api.EPICResponseItem
import com.example.materiallesson.api.PictureOfTheDayResponse

interface NasaRepository {

    suspend fun getNasaPictureOfTheDay() : PictureOfTheDayResponse
    suspend fun getEPICPicture() : ArrayList<EPICResponseItem>
}