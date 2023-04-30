package com.example.springhexagonal.domain.user.api

import com.example.springhexagonal.domain.user.api.dto.request.DomainSignInRequest
import com.example.springhexagonal.domain.user.api.dto.response.SignInResponse

interface SignInPort {
    fun signIn(request: DomainSignInRequest): SignInResponse
}