package com.example.data.service.api.response

import com.google.gson.annotations.SerializedName

data class AuthenticateResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("status_code") val statusCode: Int,
    @SerializedName("status_message") val statusMessage: String
)
