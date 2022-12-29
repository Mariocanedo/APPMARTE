package com.example.appmarte.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.appmarte.R
import com.example.appmarte.ViewModel.MarsViewModel
import com.example.appmarte.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

private lateinit var _binding: FragmentSecondBinding
private val viewModel : MarsViewModel by activityViewModels()
    var idMars: String= ""

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idMars = it.getString("id","")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }

        viewModel.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                Glide.with(_binding.ivTerrain)
                    .load(it.img_Src).centerCrop().into(_binding.ivTerrain)
                _binding.tvPrice.text= it.price.toString()
                _binding.tvType.text = it.type
            }
        })

        _binding.btnReturn.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }





    }


}