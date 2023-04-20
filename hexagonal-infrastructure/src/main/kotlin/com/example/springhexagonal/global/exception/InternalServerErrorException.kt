package com.example.springhexagonal.global.exception

import com.example.springhexagonal.error.CustomException
import com.example.springhexagonal.global.error.ErrorCode

object InternalServerErrorException : CustomException (
        ErrorCode.INTERNAL_SERVER_ERROR
) {
    val Exception = InternalServerErrorException
}