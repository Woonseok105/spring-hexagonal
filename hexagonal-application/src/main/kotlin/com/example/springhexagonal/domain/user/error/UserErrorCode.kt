package com.example.springhexagonal.domain.user.error

import com.example.springhexagonal.error.ErrorProperty

enum class UserErrorCode (
        override val status: Int,
        override val message: String
) : ErrorProperty {

    USER_INVALID_PASSWORD(401, "잘못된 비밀번호입니다."),

    USER_NOT_FOUND(404, "User Not Foud Error")

}