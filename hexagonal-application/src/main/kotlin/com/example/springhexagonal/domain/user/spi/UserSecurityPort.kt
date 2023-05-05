package com.example.springhexagonal.domain.user.spi

interface UserSecurityPort {

    fun matches(rawPassword: String, encodedPassword: String): Boolean

    fun encodePassword(password: String): String
}