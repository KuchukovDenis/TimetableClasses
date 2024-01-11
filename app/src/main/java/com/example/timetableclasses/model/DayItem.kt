package com.example.timetableclasses.model

import java.util.Calendar

data class DayItem(
    val name: String,
    val dayOfWeek: Int,
    val lessons: List<LessonItem>
)