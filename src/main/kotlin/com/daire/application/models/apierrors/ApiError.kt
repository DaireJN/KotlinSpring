package com.daire.application.models.apierrors

import org.springframework.http.HttpStatus
import java.util.*


class ApiError {

    var status: HttpStatus? = null
    var message: String? = null
    var errors: List<String>? = null

    constructor(status: HttpStatus, message: String, errors: List<String>) : super() {
        this.status = status
        this.message = message
        this.errors = errors
    }

    constructor(status: HttpStatus, message: String) : super() {
        this.status = status
        this.message = message
    }

    constructor(status: HttpStatus, message: String, error: String) : super() {
        this.status = status
        this.message = message
        errors = mutableListOf(error)
    }
}