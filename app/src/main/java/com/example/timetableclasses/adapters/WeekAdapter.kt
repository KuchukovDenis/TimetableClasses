package com.example.timetableclasses.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timetableclasses.R
import com.example.timetableclasses.databinding.DayItemBinding
import com.example.timetableclasses.model.DayItem

class WeekAdapter : RecyclerView.Adapter<WeekAdapter.WeekViewHolder>() {

    class WeekViewHolder(
        private val binding: DayItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        private val adapter = LessonsAdapter()
        fun bind(dayItem: DayItem) = with(binding) {
            binding.name.text = dayItem.name

            binding.lessonsRecyclerView.adapter = adapter
            binding.lessonsRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
            adapter.submitList(dayItem.lessons)
        }

    }

    private val list: MutableList<DayItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DayItemBinding.inflate(inflater, parent, false)
        return WeekViewHolder(binding)
    }

    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun submitList(list: List<DayItem>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

}