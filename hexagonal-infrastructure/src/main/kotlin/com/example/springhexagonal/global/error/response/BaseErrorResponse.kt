package com.example.springhexagonal.global.error.response

import com.example.springhexagonal.error.CustomException
import com.example.springhexagonal.error.ErrorProperty

class BaseErrorResponse (
        val status: Int,
        val message: String
) {

    companion object {
        fun of(e: CustomException): BaseErrorResponse {
            return BaseErrorResponse(
                    status = e.status,
                    message = e.message
            )
        }
    }
}