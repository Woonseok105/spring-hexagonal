package com.example.springhexagonal.domain.user.spi

import com.example.springhexagonal.domain.user.domain.User

interface CommandUserPort {
    fun saveUser(user: User)
}