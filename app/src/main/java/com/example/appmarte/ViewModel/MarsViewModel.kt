package com.example.appmarte.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmarte.Model.Remote.MarsRealState
import com.example.appmarte.Model.Remote.MarsRepository
import kotlinx.coroutines.launch


class MarsViewModel :ViewModel(){
    ////////// PARTEN 1//////////////////////////////////////
    private val repository : MarsRepository
    // representa la respuesta de la api
    //val liveDatafromInternet : LiveData<List<MarsRealState>>


    //PARTE 2
    lateinit var liveDatafromInternet : LiveData<List<MarsRealState>>
    init{
        repository = MarsRepository()
        // PARTE 1
       // liveDatafromInternet = repository.fetchDataMars()
        // PARTE 2

        viewModelScope.launch {
            // PARTE 1
        //    liveDatafromInternet = repository.fetchDataMars
            // PARTE 2
            repository.fetchDataFromInternetCoroutines()
        }
        liveDatafromInternet = repository.dataFromInternet

    }

// funcion para selecccionar
    // guardarmos la selecciona en una mutableLiveData
    private var selectedMarsTerrain: MutableLiveData<MarsRealState> = MutableLiveData()

    // Ocupamos una función  y tomamos la posiciona seleccionada
    fun selected(mars :MarsRealState){
        selectedMarsTerrain.value = mars
    }

    fun selectedItem(): LiveData<MarsRealState> = selectedMarsTerrain




}