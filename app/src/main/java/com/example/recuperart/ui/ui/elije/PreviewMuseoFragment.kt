package com.example.recuperart.ui.ui.elije

import android.os.Bundle
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
import com.example.recuperart.io.model.PreviewMuseo
import com.example.recuperart.viewmodel.AllMuseusViewModel

class PreviewMuseoFragment : Fragment() {

    private lateinit var allMuseusViewModel: AllMuseusViewModel
    private lateinit var museusAdapter: PreviewMuseoRecyclerViewAdapter
    private var allMuseus : ArrayList<PreviewMuseo> = ArrayList()
    private var columnCount = 1

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
        val view = inflater.inflate(R.layout.fragment_item_pm_list, container, false)
        // Get ViewModel
        allMuseusViewModel = ViewModelProvider(this).get(AllMuseusViewModel::class.java)
        museusAdapter = activity?.let { PreviewMuseoRecyclerViewAdapter(it) }!!
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = museusAdapter
            }
        }
        // Observer of the museums
        allMuseusViewModel.getAllMuseus().observe(viewLifecycleOwner, Observer {
            allMuseus = it
            Constantes.NUM_MUSEO = allMuseus.size
            museusAdapter.setData(allMuseus)
        })

        return view
    }


    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            PreviewMuseoFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}