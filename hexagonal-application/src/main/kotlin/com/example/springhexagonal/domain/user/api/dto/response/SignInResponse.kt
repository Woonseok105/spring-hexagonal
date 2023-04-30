package com.example.springhexagonal.domain.user.api.dto.response

class SignInResponse (
        private val accessToken: String,
        private val refreshToken: String
)