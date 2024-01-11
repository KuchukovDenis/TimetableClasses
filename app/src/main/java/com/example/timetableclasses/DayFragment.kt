package com.example.timetableclasses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timetableclasses.adapters.LessonsAdapter
import com.example.timetableclasses.databinding.FragmentDayBinding
import com.example.timetableclasses.model.LessonItem

class DayFragment : Fragment() {

    private var binding: FragmentDayBinding? = null

    private val adapter = LessonsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding?.lessonsRecyclerView) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@DayFragment.adapter
            addItemDecoration(createItemDecorator())
        }

        binding?.firstWeek?.text = "Первая неделя"
        binding?.firstWeek?.setOnClickListener {
            adapter.submitList(Data().getLessonsToday(1))
        }

        binding?.secondWeek?.text = "Вторая неделя"
        binding?.secondWeek?.setOnClickListener {
            adapter.submitList(Data().getLessonsToday(2))
        }

        adapter.submitList(Data().getLessonsToday(1))

    }

    private fun createItemDecorator() =
        DividerItemDecoration(requireContext(), RecyclerView.VERTICAL).apply {
            ContextCompat.getDrawable(requireContext(), R.drawable.lessons_item_decorator)
                ?.let { this@apply.setDrawable(it) }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DayFragment()
    }
}