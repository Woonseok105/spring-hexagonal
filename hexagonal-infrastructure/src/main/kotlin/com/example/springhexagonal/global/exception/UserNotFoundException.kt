package com.example.springhexagonal.global.exception

import com.example.springhexagonal.error.CustomException
import com.example.springhexagonal.global.error.ErrorCode

object UserNotFoundException : CustomException(
        ErrorCode.USER_NOT_FOUND
) {
    val Exception = UserNotFoundException
}