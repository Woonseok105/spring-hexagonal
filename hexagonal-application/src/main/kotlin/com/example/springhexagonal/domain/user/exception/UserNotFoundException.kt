package com.example.springhexagonal.domain.user.exception

import com.example.springhexagonal.domain.user.error.UserErrorCode
import com.example.springhexagonal.error.CustomException

object UserNotFoundException : CustomException(
        UserErrorCode.USER_NOT_FOUND
)