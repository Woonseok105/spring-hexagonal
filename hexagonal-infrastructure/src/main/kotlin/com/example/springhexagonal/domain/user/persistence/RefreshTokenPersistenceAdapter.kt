package com.example.springhexagonal.domain.user.persistence

import com.example.springhexagonal.domain.user.domain.RefreshToken
import com.example.springhexagonal.domain.user.mapper.RefreshTokenMapper
import com.example.springhexagonal.domain.user.spi.RefreshTokenPort
import com.example.springhexagonal.global.annotation.Adaptor

@Adaptor
class RefreshTokenPersistenceAdapter (
        private val refreshTokenRepository: RefreshTokenRepository,
        private val refreshTokenMapper: RefreshTokenMapper
) : RefreshTokenPort {

    override fun saveRefreshToken(refreshToken: RefreshToken) {
        refreshTokenRepository.save(refreshTokenMapper.domainToEntity(refreshToken))
    }
}