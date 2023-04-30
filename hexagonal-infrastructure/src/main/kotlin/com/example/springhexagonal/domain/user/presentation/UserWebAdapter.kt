package com.example.springhexagonal.domain.user.presentation

import com.example.springhexagonal.domain.user.api.SignInPort
import com.example.springhexagonal.domain.user.api.dto.request.DomainSignInRequest
import com.example.springhexagonal.domain.user.api.dto.response.SignInResponse
import com.example.springhexagonal.domain.user.presentation.dto.request.WebSignInRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserWebAdapter (
        private val signInPort: SignInPort
) {

    @PostMapping("/auth")
    fun signIn(@RequestBody @Valid request: WebSignInRequest): SignInResponse {
        println(1)
        println(request)
        return signInPort.signIn(DomainSignInRequest(
                accountId = request.accountId,
                password = request.password
        ))
    }

    @GetMapping("/test")
    fun test(): Int {
        println(1)
        val n = 1
        return n
    }

}