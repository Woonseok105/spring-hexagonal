package com.example.springhexagonal.domain.user.domain

import com.example.springhexagonal.annotation.Aggregate

@Aggregate
class User (

        val id: Long = 0,

        val accountId: String,

        val password: String
)