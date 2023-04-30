package com.example.springhexagonal.error



open class CustomException (val errorCode: ErrorProperty) : RuntimeException() {

    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message
}