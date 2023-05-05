package com.example.springhexagonal.domain.user.presentation

import com.example.springhexagonal.domain.user.api.SignInPort
import com.example.springhexagonal.domain.user.api.SignUpPort
import com.example.springhexagonal.domain.user.api.dto.request.DomainSignInRequest
import com.example.springhexagonal.domain.user.api.dto.request.DomainSignUpRequest
import com.example.springhexagonal.domain.user.api.dto.response.SignInResponse
import com.example.springhexagonal.domain.user.presentation.dto.request.WebSignInRequest
import com.example.springhexagonal.domain.user.presentation.dto.request.WebSignUpRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserWebAdapter (
        private val signInPort: SignInPort,
        private val signUpPort: SignUpPort
) {

    @PostMapping("/auth")
    fun signIn(@RequestBody @Valid request: WebSignInRequest): SignInResponse {
        return signInPort.signIn(DomainSignInRequest(
                accountId = request.accountId,
                password = request.password
        ))
    }

    @PostMapping("/register")
    fun signUp(@RequestBody request: WebSignUpRequest) {
        signUpPort.signUp(DomainSignUpRequest(
                accountId = request.accountId,
                password = request.password
        ))
    }
}