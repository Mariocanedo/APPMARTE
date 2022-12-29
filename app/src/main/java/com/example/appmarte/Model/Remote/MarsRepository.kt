package com.example.appmarte.Model.Remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MarsRepository {

    // llama al metodo de conexion
    private val retrofitClient = RetrofitClient.getRetrofit()

    // HACE REFERENCIA AL POJO Y LA RESPUESTA VAMOS A RECIBIR
    val dataFromInternet = MutableLiveData<List<MarsRealState>>()


    fun fetchDataMars(): LiveData<List<MarsRealState>> {  // Vieja confiable
        Log.d("REPO", "VIEJA CONFIABLE")
        retrofitClient.fetchMarsData().enqueue(object : retrofit2.Callback<List<MarsRealState>> {
            override fun onResponse(
                call: Call<List<MarsRealState>>,
                response: Response<List<MarsRealState>>
            ) {
                when (response.code()) {

                    in 200..299 -> dataFromInternet.value = response.body()
                    in 300..301 -> Log.d("REPO", "${response.code()}  ---${response.errorBody()}")
                    else -> Log.d(
                        "REPO", "${response.code()} --- ${response.errorBody()}"
                    )


                }
            }

            override fun onFailure(call: Call<List<MarsRealState>>, t: Throwable) {
                Log.e("REPO", "${t.message}")
            }
        })
        // LISTA DE LOS ELEMEMTOS
        return dataFromInternet


    }


    // NUEVA FORMA CON COROUTINES PARTE 2
    suspend fun fetchDataFromInternetCoroutines(){
        try {
            val response = retrofitClient.fetchMarsDataCoroutines()
            when (response.code()) {
                in 200..299 -> dataFromInternet.value = response.body()
                in 300..301 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO", "${response.code()} --- ${response.errorBody().toString()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "${t.message}")
        }
    }


    fun getTerrainByID( id: String) : LiveData<MarsRealState>{
        return getTerrainByID(id)
    }

}


