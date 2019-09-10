package com.github.mohamedwael.latestnews.applevel

import android.text.format.DateUtils
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat


fun formatTime(isoDateToBeConverted: String): String {
    val timeZone = DateTimeZone.getDefault()
    val formatter = DateTimeFormat.forPattern("dd MMMM HH:MM").withZone(timeZone)
    val dateTime2 = timeToMillis(isoDateToBeConverted)
    return formatter.print(dateTime2)
}


fun timeToMillis(isoDateToBeConverted: String): Long {
    return DateTime(isoDateToBeConverted, DateTimeZone.getDefault()).millis
}

fun getRelativeTime(isoDateToBeConverted: String): CharSequence {
    return DateUtils.getRelativeTimeSpanString(
        timeToMillis(isoDateToBeConverted),
        System.currentTimeMillis(),
        0L,
        DateUtils.FORMAT_ABBREV_ALL
    )
}