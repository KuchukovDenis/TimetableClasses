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
import com.example.timetableclasses.adapters.WeekAdapter
import com.example.timetableclasses.databinding.FragmentWeekBinding
import com.example.timetableclasses.model.DayItem
import com.example.timetableclasses.model.LessonItem

class WeekFragment : Fragment() {

    private var binding: FragmentWeekBinding? = null

    private val adapter = WeekAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding?.daysRecyclerView) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@WeekFragment.adapter
            addItemDecoration(createItemDecorator())
        }

        binding?.firstWeek?.text = "Первая неделя"
        binding?.firstWeek?.setOnClickListener {
            adapter.submitList(Data().getWeek(1))
        }

        binding?.secondWeek?.text = "Вторая неделя"
        binding?.secondWeek?.setOnClickListener {
            adapter.submitList(Data().getWeek(2))
        }

        adapter.submitList(Data().getWeek(1))

    }

    private fun createItemDecorator() =
        DividerItemDecoration(requireContext(), RecyclerView.VERTICAL).apply {
            ContextCompat.getDrawable(requireContext(), R.drawable.days_item_decorator)
                ?.let { this@apply.setDrawable(it) }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = WeekFragment()
    }
}