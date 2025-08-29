package com.test.weatherappliaction.model.local_tbl

import androidx.annotation.NonNull
import androidx.room.Entity

@Entity(primaryKeys = ["instructor_id"])
data class WeatherLocalData(
    @NonNull
    val instructor_id: String = "",
    val client_id: String? = "",
    val email_key: String? = "",
    val eula_status: String? = "",
    val field_key: String? = "",
    val instructor_email: String? = "",
    val instructor_firstname: String? = "",
    val instructor_lastname: String? = "",
    val instructor_password: String? = "",
    val privacy_policy_status: String? = "",
    val volunteering_time_gap: String? = "",
    val instructor_register: String? = ""
)