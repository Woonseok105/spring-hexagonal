package com.example.springhexagonal.domain.user.spi

import com.example.springhexagonal.domain.user.spi.dto.SpiTokenResponse

interface UserJwtPort {
    fun provideBothToken(userId: Long): SpiTokenResponse
}