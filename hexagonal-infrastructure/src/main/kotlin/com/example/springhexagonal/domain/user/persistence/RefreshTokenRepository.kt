package com.example.springhexagonal.domain.user.persistence

import com.example.springhexagonal.domain.user.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
    fun findByRefreshToken(refreshToken: String)
}