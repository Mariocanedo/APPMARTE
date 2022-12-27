package com.example.appmarte.Model.Remote

import com.google.gson.annotations.SerializedName



// SI QUIERE TRABAJAR CON COROUTINES ESTA CLASE QUEDA IGUAL
data class MarsRealState (
    @SerializedName("id")
    val id: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("img_src")
    val img_Src: String

)