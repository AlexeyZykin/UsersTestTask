package com.example.testtask.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateTypeConverter {
    private const val INPUT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private const val OUTPUT_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss"

    fun convertDateToString(date: String): String {
        val inputFormat = SimpleDateFormat(INPUT_DATE_FORMAT, Locale.getDefault())
        val outputFormat = SimpleDateFormat(OUTPUT_TIME_FORMAT, Locale.getDefault())
        val dateOutput = inputFormat.parse(date)
        return outputFormat.format(dateOutput!!)
    }
}