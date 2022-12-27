package com.example.appmarte

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmarte.Model.Remote.MarsRealState
import com.example.appmarte.databinding.MarsItemBinding

class AdapterMars  : RecyclerView.Adapter<AdapterMars.MarsVh>() {
    private var listMarsItem = listOf<MarsRealState>()


    // falta una funciona para actualizar el adaptar notifyDataSetchanged()


    inner class MarsVh(private val binding: MarsItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        fun bin(mars: MarsRealState) {
            // Aca glide no olvidar dependencias

            // aca fata implementar algo muy importante

        }


        override fun onClick(v: View?) {
            // seleccionar un elemento a futuro

        }

    }

    // infla la vista de los elementos del layout mars_item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVh {
        TODO("Not yet implemented")
    }


    // indica una posicion
    override fun onBindViewHolder(holder: MarsVh, position: Int) {
        TODO("Not yet implemented")
    }


    // lleva la cuenta de cuantos elementos
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}