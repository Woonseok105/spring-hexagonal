package com.example.springhexagonal.global.exception

import com.example.springhexagonal.error.CustomException
import com.example.springhexagonal.global.error.ErrorCode

object InvalidToken : CustomException (
        ErrorCode.INVALID_TOKEN
)