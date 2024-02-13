package com.example.data.mapper

interface BaseResponseMapper<I, O> {
    suspend fun transform(input: I?): O
}
