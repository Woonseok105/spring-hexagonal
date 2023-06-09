package com.example.springhexagonal.global.error

import com.example.springhexagonal.error.ErrorProperty

enum class ErrorCode (
        override val status: Int,
        override val message: String
) : ErrorProperty {

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}