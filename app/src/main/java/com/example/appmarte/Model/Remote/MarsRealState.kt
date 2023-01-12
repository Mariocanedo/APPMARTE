package com.example.appmarte.Model.Remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



// SI QUIERE TRABAJAR CON COROUTINES ESTA CLASE QUEDA IGUAL
// VAMOS AGREGAR ROOM
@Entity(tableName = "mars_table")
data class MarsRealState (
    @SerializedName("id")
    @PrimaryKey
    val id: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("img_src")
    val img_Src: String

)