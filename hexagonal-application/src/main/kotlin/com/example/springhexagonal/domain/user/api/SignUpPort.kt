package com.example.springhexagonal.domain.user.api

import com.example.springhexagonal.domain.user.api.dto.request.DomainSignUpRequest

interface SignUpPort {

    fun signUp(request: DomainSignUpRequest)
}