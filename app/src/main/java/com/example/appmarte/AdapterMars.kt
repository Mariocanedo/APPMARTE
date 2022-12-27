<<<<<<< HEAD
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

=======
package com.example.retrofitexample_0

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appmarte.Model.Remote.MarsRealState
import com.example.appmarte.databinding.MarsItemBinding

class AdapterMars  : RecyclerView.Adapter<AdapterMars.MarsVH>() {


    private var listMarsItem = listOf<MarsRealState>()
    val selectedTerrain = MutableLiveData<MarsRealState>()

    // Funcion  para seleccionar agregar



    fun update(list: List<MarsRealState>) {
        listMarsItem = list
        notifyDataSetChanged()
    }


    //1 INNER CLASS

    inner class MarsVH(private val binding: MarsItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        fun bin(mars: MarsRealState) {
            // ACA glide no olvidar dependencias
            Glide.with(binding.imageView2).load(mars.img_Src).centerCrop().into(binding.imageView2)
            // Activar el Clik
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
          // falta implementar al seleccionar un elemento
>>>>>>> ec75243 (Falta Completar El adapter e implementarlo en la Vista)
        }

    }

<<<<<<< HEAD
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
=======

    //_______________________________Estos Métodos se implementan----------------------------

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVH {
        return MarsVH(MarsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsVH, position: Int) {
        val terrain = listMarsItem[position]
        holder.bin(terrain)
    }

    override fun getItemCount(): Int =
        listMarsItem.size
}


>>>>>>> ec75243 (Falta Completar El adapter e implementarlo en la Vista)
