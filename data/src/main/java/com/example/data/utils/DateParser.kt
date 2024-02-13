package com.example.data.utils

import java.time.Instant
import java.util.Date
import javax.inject.Inject

class DateParser @Inject constructor() {
    // TODO: Create real method implementation
    suspend fun converseDateFromStringToDate(date: String?): Date = Date.from(Instant.now())
}
