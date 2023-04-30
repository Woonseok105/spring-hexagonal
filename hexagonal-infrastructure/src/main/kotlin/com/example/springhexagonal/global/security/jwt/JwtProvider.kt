package com.example.springhexagonal.global.security.jwt

import com.example.springhexagonal.domain.user.spi.UserJwtPort
import com.example.springhexagonal.domain.user.spi.dto.SpiTokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider (
        private val securityProperties: SecurityProperties
) : UserJwtPort {

    private fun createAccessToken(userId: Long) =
            generateToken(userId, JwtProperties.ACCESS, securityProperties.accessExp)

    private fun createRefreshToken(userId: Long) =
            generateToken(userId, JwtProperties.REFRESH, securityProperties.refreshExp)

    private fun generateToken(userId: Long, type:String, expiredAt: Long) =
            Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
                    .setSubject(userId.toString())
                    .setHeaderParam("type", "jwt")
                    .claim("type", type)
                    .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
                    .compact()

    override fun provideBothToken(userId: Long) = SpiTokenResponse(
            accessToken = createAccessToken(userId),
            refreshToken = createRefreshToken(userId),
            refreshTokenExp = securityProperties.refreshExp
    )

}