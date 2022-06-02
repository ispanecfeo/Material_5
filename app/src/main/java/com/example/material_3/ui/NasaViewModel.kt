package com.example.material_3.ui

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.material_3.R
import com.example.material_3.domain.NasaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import java.text.SimpleDateFormat

class NasaViewModel(private val repository: NasaRepository) : ViewModel() {

    val baseAddress = "https://epic.gsfc.nasa.gov/archive/natural/"

    private val _image: MutableStateFlow<String?> = MutableStateFlow(null)
    val image: Flow<String?> = _image

    fun requestPicture(position: Int) {
        when (position) {
            0 -> requestEpicPicture()
            1 -> requestPictureOfTheDay()
        }
    }


    private fun requestEpicPicture() {

        viewModelScope.launch {
            try {
                val responseList = repository.getEPICPicture()
                val response = responseList[0]
                val simpleFormat = SimpleDateFormat("YYYY/MM/dd")
                val address = baseAddress +
                        simpleFormat.format(response.date) +
                        "/png/" + response.image + ".png"
                _image.emit(address)

            } catch (e: IOException) {

            }
        }
    }

    private fun requestPictureOfTheDay() {

        viewModelScope.launch {
            try {
                val nasaResponse = repository.getNasaPictureOfTheDay()
                _image.emit(nasaResponse.url)
            } catch (e: IOException) {

            }
        }

    }

}

class NasaViewModelFactory(private val repository: NasaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = NasaViewModel(repository) as T
}