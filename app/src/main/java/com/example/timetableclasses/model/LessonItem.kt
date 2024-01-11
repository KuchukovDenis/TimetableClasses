package com.example.timetableclasses.model

data class LessonItem(
    val name: String,
    val classroom: String,
    val timeStart: String,
    val timeEnd: String,
    val teacher: String
)