package com.example.springhexagonal.domain.user.usecase

import com.example.springhexagonal.annotation.UseCase
import com.example.springhexagonal.domain.user.api.SignInPort
import com.example.springhexagonal.domain.user.api.dto.request.DomainSignInRequest
import com.example.springhexagonal.domain.user.api.dto.response.SignInResponse
import com.example.springhexagonal.domain.user.domain.RefreshToken
import com.example.springhexagonal.domain.user.exception.UserInvaildPasswordException
import com.example.springhexagonal.domain.user.spi.CommandRefreshPort
import com.example.springhexagonal.domain.user.spi.QueryUserPort
import com.example.springhexagonal.domain.user.spi.UserJwtPort
import com.example.springhexagonal.domain.user.spi.UserSecurityPort

@UseCase
open class SignInUseCase ( //TODO 왜 OPEN을 달아주면 에러가 안날까????
        private val queryUserPort: QueryUserPort,
        private val userSecurityPort: UserSecurityPort,
        private val userJwtPort: UserJwtPort,
        private val commandRefreshPort: CommandRefreshPort
) : SignInPort {

    override fun signIn(request: DomainSignInRequest): SignInResponse {
        println(1)
        val user = queryUserPort.queryUserByAccountId(request.accountId)
        println(user)

        if (!userSecurityPort.matches(request.password, user.password)) {
            throw UserInvaildPasswordException
        }

        val tokenResponse = userJwtPort.provideBothToken(user.id)

        commandRefreshPort.saveRefreshToken(
                RefreshToken(
                        id = user.id.toString(),
                        refreshToken = tokenResponse.refreshToken,
                        ttl = tokenResponse.refreshTokenExp
                )
        )

        return SignInResponse(
                accessToken = tokenResponse.accessToken,
                refreshToken = tokenResponse.refreshToken
        )
    }
}