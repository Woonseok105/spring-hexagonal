package com.example.springhexagonal.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

class WebSignUpRequest (

        @NotBlank
        val accountId: String,

        @NotBlank
        val password: String
)