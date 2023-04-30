package com.example.springhexagonal.domain.user.domain

import com.example.springhexagonal.annotation.Aggregate

@Aggregate
class RefreshToken (
        val id: String,

        var refreshToken: String,

        var ttl: Long
) {

    fun updateToken(refreshToken: String, ttl: Long) {
        this.refreshToken = refreshToken
        this.ttl = ttl
    }
}