package com.example.timetableclasses

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.timetableclasses.model.DayItem
import com.example.timetableclasses.model.LessonItem
import com.example.timetableclasses.model.WeekItem
import java.time.DayOfWeek
import java.util.Calendar

class Data {
    fun getWeek(numWeek: Int) : List<DayItem> {
        return when(numWeek){
            1 -> firstWeek.days
            2 -> secondWeek.days
            else -> firstWeek.days
        }
    }

    fun getLessonsToday(numWeek: Int): List<LessonItem> {
        val emptyDay = listOf(
            LessonItem(
                name="Пусто",
                classroom="-",
                timeStart="00:00",
                timeEnd="00:00",
                teacher="-"
            ))
        val days = getWeek(numWeek)
        val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        return days.find { it.dayOfWeek == dayOfWeek }?.lessons ?: emptyDay
    }

    private val firstWeek = WeekItem(
        1,
        listOf(
            DayItem(
                name = "Понедельник",
                dayOfWeek = Calendar.MONDAY,
                lessons = listOf(
                    LessonItem(
                        name="русский язык",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="русский язык",
                        classroom="132",
                        timeStart="13:00",
                        timeEnd="13:40",
                        teacher="учитель"
                    ),
                )
            ),
            DayItem(
                name = "Вторник",
                dayOfWeek = Calendar.TUESDAY,
                lessons = listOf(
                    LessonItem(
                        name="философия",
                        classroom="132ф",
                        timeStart="12:50",
                        timeEnd="13:30",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="математика",
                        classroom="132р",
                        timeStart="14:00",
                        timeEnd="14:40",
                        teacher="учитель"
                    ),
                )
            ) ,
            DayItem(
                name = "Среда",
            dayOfWeek = Calendar.WEDNESDAY,
            lessons = listOf(
                LessonItem(
                    name="истрория",
                    classroom="132",
                    timeStart="9:00",
                    timeEnd="9:40",
                    teacher="учитель"
                ),
                LessonItem(
                    name="физра",
                    classroom="132",
                    timeStart="10:00",
                    timeEnd="10:40",
                    teacher="учитель"
                     ),
                )
            ),

            DayItem(
                name = "Четверг",
                dayOfWeek = Calendar.THURSDAY,
                lessons = listOf(
                    LessonItem(
                        name="английский язык",
                        classroom="132",
                        timeStart="9:00",
                        timeEnd="9:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="программирование",
                        classroom="132",
                        timeStart="10:00",
                        timeEnd="10:40",
                        teacher="учитель"
                    ),
                )
            ),

            DayItem(
                name = "Пятница",
                dayOfWeek = Calendar.FRIDAY,
                lessons = listOf(
                    LessonItem(
                        name="информатика",
                        classroom="132",
                        timeStart="9:00",
                        timeEnd="9:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="физика",
                        classroom="132",
                        timeStart="10:00",
                        timeEnd="10:40",
                        teacher="учитель"
                    ),
                )
            ),

            DayItem(
                name = "Суббота",
                dayOfWeek = Calendar.SATURDAY,
                lessons = listOf(
                    LessonItem(
                        name="география",
                        classroom="132",
                        timeStart="9:00",
                        timeEnd="9:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="биология",
                        classroom="132",
                        timeStart="10:00",
                        timeEnd="10:40",
                        teacher="учитель"
                    ),
                )
            ),
        )
    )

    private val secondWeek = WeekItem(
        2,
        listOf(
            DayItem(
                name = "Понедельник",
                dayOfWeek = Calendar.MONDAY,
                lessons = listOf(
                    LessonItem(
                        name="математика",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="математика",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                )
            ),
            DayItem(
                name = "Вторник",
                dayOfWeek = Calendar.TUESDAY,
                lessons = listOf(
                    LessonItem(
                        name="физика",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="физра",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                )
            ),
            DayItem(
                name = "Среда",
                dayOfWeek = Calendar.WEDNESDAY,
                lessons = listOf(
                    LessonItem(
                        name="география",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="обществознание",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                )
            ),
            DayItem(
                name = "Четверг",
                dayOfWeek = Calendar.THURSDAY,
                lessons = listOf(
                    LessonItem(
                        name="информатика",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="программирование",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                )
            ),
            DayItem(
                    name = "Пятница",
            dayOfWeek = Calendar.FRIDAY,
            lessons = listOf(
                LessonItem(
                    name="БЖД",
                    classroom="132",
                    timeStart="12:00",
                    timeEnd="12:40",
                    teacher="учитель"
                ),
                LessonItem(
                    name="Башкирский язык",
                    classroom="132",
                    timeStart="12:00",
                    timeEnd="12:40",
                    teacher="учитель"
                    ),
                )
            ),
            DayItem(
                name = "Суббота",
                dayOfWeek = Calendar.SATURDAY,
                lessons = listOf(
                    LessonItem(
                        name="математика",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                    LessonItem(
                        name="русский язык",
                        classroom="132",
                        timeStart="12:00",
                        timeEnd="12:40",
                        teacher="учитель"
                    ),
                )
            ),
        )
    )
}