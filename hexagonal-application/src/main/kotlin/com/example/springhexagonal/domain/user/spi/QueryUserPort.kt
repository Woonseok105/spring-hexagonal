package com.example.springhexagonal.domain.user.spi

import com.example.springhexagonal.domain.user.domain.User

interface QueryUserPort {
    fun queryUserByAccountId(accountId: String): User
}