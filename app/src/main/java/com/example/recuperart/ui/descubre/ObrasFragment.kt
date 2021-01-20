package com.example.recuperart.ui.descubre

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recuperart.R
import com.example.recuperart.io.Constantes
import com.example.recuperart.io.model.Obra
import com.example.recuperart.repository.ObrasRepository
import com.example.recuperart.viewmodel.*


class ObrasFragment() : Fragment() {

    private  var arrayObras: ArrayList<Obra> = ArrayList()

    private lateinit var obrasAdapter: ObrasRecyclerViewAdapter
    private var columnCount = 1

    private lateinit var viewModelobras: ViewModelObras
    val repositoryobras =ObrasRepository()
    val viewModelFactoryobras = ViewModelFactoryObras(repositoryobras)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_item_o_list, container, false)
        obrasAdapter = activity?.let { ObrasRecyclerViewAdapter(it) }!!

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = obrasAdapter
            }
        }

        viewModelobras = ViewModelProvider(this, viewModelFactoryobras).get(ViewModelObras::class.java)
        viewModelobras.getObras(Constantes.ID.toInt())
        viewModelobras.myResponse.observe( viewLifecycleOwner , Observer { response ->
            if (response.isSuccessful){
                arrayObras= response.body()?.ans!!
                obrasAdapter.setData(arrayObras)
            }else{
                Log.d("Response", response.errorBody().toString())
            }
        })

        return view
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(columnCount: Int) =
            ObrasFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}