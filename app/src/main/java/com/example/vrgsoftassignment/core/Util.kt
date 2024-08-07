package com.example.vrgsoftassignment.core

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

 fun dateOfPosting(timeCreated: Long): String {
    val dateTimeOfPosting =
        Instant.ofEpochSecond(timeCreated).atZone(ZoneId.systemDefault()).toLocalDateTime()
    val currentDateTime = LocalDateTime.now()
    return when {
        ChronoUnit.HOURS.between(
            dateTimeOfPosting,
            currentDateTime
        ) < 24 -> "${ChronoUnit.HOURS.between(dateTimeOfPosting, currentDateTime)} hours ago"

        else -> "${ChronoUnit.DAYS.between(dateTimeOfPosting, currentDateTime)} days ago"
    }

}