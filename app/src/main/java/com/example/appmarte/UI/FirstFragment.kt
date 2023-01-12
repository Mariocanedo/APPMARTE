package com.example.appmarte.UI
import android.os.Bundle
import com.example.retrofitexample_0.AdapterMars



import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.appmarte.R
import com.example.appmarte.ViewModel.MarsViewModel
import com.example.appmarte.databinding.FragmentFirstBinding

import androidx.recyclerview.widget.GridLayoutManager



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
/*
        viewModel.liveDatafromInternet.observe(viewLifecycleOwner, Observer {
            it?.let{
              _binding.textviewFirst.text = it.toString()

*/



        // instanciar el adapter
        val adapter = AdapterMars()
        // buscar el recyclerView
        _binding.rvTerrains.adapter = adapter
        _binding.rvTerrains.layoutManager= GridLayoutManager(context,2)

   adapter.selectedItem().observe(viewLifecycleOwner, Observer {
       it.let{

           viewModel.selected(it)
           findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
       }

   })
      /*  viewModel.liveDatafromInternet.observe(viewLifecycleOwner, Observer {
            it?.let{
            adapter.update(it)
           // Log.d("Listado",it.toString())


            }
        })*/



        viewModel.allTask.observe(viewLifecycleOwner, Observer {

            adapter.update(it)
            Log.d("Listado",it.toString())
        })






    }


}