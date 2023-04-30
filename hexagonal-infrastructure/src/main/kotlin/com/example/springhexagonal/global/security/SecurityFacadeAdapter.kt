package com.example.springhexagonal.global.security

import com.example.springhexagonal.domain.user.spi.UserSecurityPort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class SecurityFacadeAdapter (
        private val passwordEncoder: PasswordEncoder
) : UserSecurityPort {

    override fun matches(rawPassword: String, encodedPassword: String): Boolean =
            passwordEncoder.matches(rawPassword, encodedPassword)
}