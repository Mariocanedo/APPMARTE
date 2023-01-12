package com.example.appmarte.ViewModel

import android.app.Application
import android.app.TaskInfo
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmarte.Model.Local.MarsDao
import com.example.appmarte.Model.Local.MarsDataBase
import com.example.appmarte.Model.Remote.MarsRealState
import com.example.appmarte.Model.Remote.MarsRepository
import kotlinx.coroutines.launch


class MarsViewModel (application: Application): AndroidViewModel(application){
    ////////// PARTEN 1//////////////////////////////////////
    private val repository : MarsRepository
    // representa la respuesta de la api
    //val liveDatafromInternet : LiveData<List<MarsRealState>>


    //PARTE 2
    lateinit var liveDatafromInternet : LiveData<List<MarsRealState>>

    // para mostrar lo que se esta recibiendo
    val allTask : LiveData<List<MarsRealState>>



    init{
        val MarsDao = MarsDataBase.getDataBase(application).getMarsDao()
        repository = MarsRepository(MarsDao)
        // PARTE 1
       // liveDatafromInternet = repository.fetchDataMars()
        // PARTE 2

        viewModelScope.launch {
            // PARTE 1
        //    liveDatafromInternet = repository.fetchDataMars
            // PARTE 2
            repository.fetchDataFromInternetCoroutines()
        }
        allTask= repository.listAllTask
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


    // funciones para insertar

    fun insertTask ( task : MarsRealState)= viewModelScope.launch {
        repository.inserTask(task)
    }

    fun updateTask ( task : MarsRealState)= viewModelScope.launch {
        repository.updateTask(task)
    }


    fun getTaskById(id:Int): LiveData<MarsRealState>{
        return  repository.getTaskById(id)
    }

}