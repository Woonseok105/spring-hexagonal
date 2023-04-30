package com.example.springhexagonal.domain.user.spi

import com.example.springhexagonal.domain.user.domain.RefreshToken

interface CommandRefreshPort {
    fun saveRefreshToken(refreshToken: RefreshToken)
}