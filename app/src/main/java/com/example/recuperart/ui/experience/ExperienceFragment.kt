package com.example.recuperart.ui.experience

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
import com.example.recuperart.data.Experience
import com.example.recuperart.viewmodel.ExperienceViewModel


class ExperienceFragment : Fragment() {

    private lateinit var experienceViewModel: ExperienceViewModel
    private lateinit var experienceAdapter: ExperienceRecyclerViewAdapter
    private var allExperiences = emptyList<Experience>()
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
        val view = inflater.inflate(R.layout.fragment_item_e_list, container, false)
        experienceViewModel = ViewModelProvider(this).get(ExperienceViewModel::class.java)
        experienceAdapter = activity?.let { ExperienceRecyclerViewAdapter(it) }!!
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = experienceAdapter
            }
        }
        experienceViewModel.readAllData.observe(viewLifecycleOwner, Observer { experience ->
            allExperiences = experience
            experienceAdapter.setData(experience)
        })
        return view
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ExperienceFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}