package com.abh.articles.commons

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    @JvmStatic
    fun getDateFormatted(date: Long): String =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(date))

    @JvmStatic
    fun getDatePrettied(date: Long): String =
        SimpleDateFormat("dd MMM, yyyy", Locale.getDefault()).format(Date(date))


    fun getTimestamp(
        format1: String,
        dateString1: String?,
        format2: String,
        dateString2: String?
    ): Long {

        val date = if (!dateString1.isNullOrEmpty()) {
            SimpleDateFormat(format1).parse(dateString1) ?: Date()
        } else if (!dateString2.isNullOrEmpty()) {
            SimpleDateFormat(format2).parse(dateString2) ?: Date()
        } else {
            Date()
        }

        return date.time
    }
}