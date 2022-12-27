package com.example.appmarte.UI

import android.os.Bundle
<<<<<<< HEAD
=======

import android.util.Log

>>>>>>> ec75243 (Falta Completar El adapter e implementarlo en la Vista)
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
<<<<<<< HEAD
import com.example.appmarte.R
import com.example.appmarte.ViewModel.MarsViewModel
import com.example.appmarte.databinding.FragmentFirstBinding
=======

import androidx.recyclerview.widget.GridLayoutManager


import com.example.appmarte.R
import com.example.appmarte.ViewModel.MarsViewModel
import com.example.appmarte.databinding.FragmentFirstBinding
import com.example.retrofitexample_0.AdapterMars
>>>>>>> ec75243 (Falta Completar El adapter e implementarlo en la Vista)

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var _binding : FragmentFirstBinding
    private val viewModel : MarsViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

<<<<<<< HEAD
        viewModel.liveDatafromInternet.observe(viewLifecycleOwner, Observer {
            it?.let{
              _binding.textviewFirst.text = it.toString()
=======
/*
        viewModel.liveDatafromInternet.observe(viewLifecycleOwner, Observer {
            it?.let {
                _binding.textviewFirst.text = it.toString()
            }
            }*/

        // instanciar el adapter
        val adapter = AdapterMars()
        // buscar el recyclerView
        _binding.rvTerrains.adapter = adapter
        _binding.rvTerrains.layoutManager= GridLayoutManager(context,2)


        viewModel.liveDatafromInternet.observe(viewLifecycleOwner, Observer {
            it?.let{
            adapter.update(it)
            Log.d("Listado",it.toString())

>>>>>>> ec75243 (Falta Completar El adapter e implementarlo en la Vista)
            }
        })




    }


}