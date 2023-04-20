package com.example.springhexagonal.domain.user.spi.dto

import java.time.LocalDateTime

data class SpiTokenResponse (
        val accessToken: String,

        val refreshToken: String,

        val accessTokenExp: LocalDateTime
)