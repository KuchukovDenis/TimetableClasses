package com.example.timetableclasses.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetableclasses.databinding.LessonItemBinding
import com.example.timetableclasses.model.LessonItem

class LessonsAdapter : RecyclerView.Adapter<LessonsAdapter.LessonsViewHolder>() {

    class LessonsViewHolder(
        private val binding: LessonItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(lessonItem: LessonItem) = with(binding) {
            binding.name.text = lessonItem.name
            binding.teacher.text = lessonItem.teacher
            binding.classroom.text = lessonItem.classroom
            binding.timeStart.text = lessonItem.timeStart
            binding.timeEnd.text = lessonItem.timeEnd
        }

    }

    private val list: MutableList<LessonItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LessonItemBinding.inflate(inflater, parent, false)
        return LessonsViewHolder(binding)
    }

    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(holder: LessonsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun submitList(list: List<LessonItem>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


}