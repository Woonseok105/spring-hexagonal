package com.example.springhexagonal.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class WebSignInRequest (

        @NotBlank
        @Size(min = 5, max = 30)
        val accountId: String,

        @NotBlank
        val password: String
)