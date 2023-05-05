package com.example.springhexagonal.domain.user.usecase

import com.example.springhexagonal.annotation.UseCase
import com.example.springhexagonal.domain.user.api.SignUpPort
import com.example.springhexagonal.domain.user.api.dto.request.DomainSignUpRequest
import com.example.springhexagonal.domain.user.domain.User
import com.example.springhexagonal.domain.user.spi.CommandUserPort
import com.example.springhexagonal.domain.user.spi.UserSecurityPort

@UseCase
open class SignUpUseCase (
        private val commandUserPort: CommandUserPort,
        private val userSecurityPort: UserSecurityPort
) : SignUpPort {

    override fun signUp(request: DomainSignUpRequest) {
        commandUserPort.saveUser(User(
                accountId = request.accountId,
                password = userSecurityPort.encodePassword(request.password)
        ))
    }
}