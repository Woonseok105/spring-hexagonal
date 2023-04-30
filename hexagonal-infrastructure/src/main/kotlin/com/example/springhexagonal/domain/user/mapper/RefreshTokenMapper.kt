package com.example.springhexagonal.domain.user.mapper

import com.example.springhexagonal.domain.user.domain.RefreshToken
import com.example.springhexagonal.domain.user.persistence.entity.RefreshTokenEntity
import org.springframework.stereotype.Component

//@Mapper(componentModel = "spring")
@Component
class RefreshTokenMapper {
    fun entityToDomain(refreshTokenEntity: RefreshTokenEntity): RefreshToken = refreshTokenEntity.let {
            RefreshToken(
                    id = it.id,
                    refreshToken = it.refreshToken,
                    ttl = it.ttl
            )
        }

    fun domainToEntity(refreshToken: RefreshToken): RefreshTokenEntity = refreshToken.let {
        RefreshTokenEntity(
                id = it.id,
                refreshToken = it.refreshToken,
                ttl = it.ttl
        )
    }
}