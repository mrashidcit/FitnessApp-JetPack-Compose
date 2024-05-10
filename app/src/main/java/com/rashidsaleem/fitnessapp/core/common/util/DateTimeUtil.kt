package com.rashidsaleem.fitnessapp.core.common.util

import java.text.SimpleDateFormat
import java.util.Date

object DateTimeUtil {

    val formatMonthDayYear = "MM-dd-yyyy"

    fun toString(date: Date?, format: String = formatMonthDayYear): String {
        if (date == null) return ""
        return try {
            val simpleDateFormat = SimpleDateFormat(format)
            simpleDateFormat.format(date)
        } catch (ex: Exception) {
            ex.printStackTrace()
            ""
        }
    }

}
