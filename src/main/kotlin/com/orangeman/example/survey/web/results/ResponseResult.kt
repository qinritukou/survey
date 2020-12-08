package com.orangeman.example.survey.web.results

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert


object ResponseResult {
    fun created(): ResponseEntity<ApiResult> {
        return ResponseEntity.status(201).build()
    }

    fun updated(): ResponseEntity<ApiResult> {
        return ResponseEntity.status(202).build()
    }

    fun deleted(): ResponseEntity<ApiResult> {
        return ResponseEntity.status(204).build()
    }

    fun ok(): ResponseEntity<ApiResult> {
        return ResponseEntity.ok().build()
    }

    fun ok(message: String): ResponseEntity<ApiResult> {
        Assert.hasText(message, "Parameter `message` must not be blank")
        return ok(ApiResult.message(message))
    }

    fun ok(payload: ApiResult): ResponseEntity<ApiResult> {
        Assert.notNull(payload, "Parameter `payload` must not be null")
        return ResponseEntity.ok(payload)
    }

    fun failure(message: String): ResponseEntity<ApiResult> {
        return ResponseEntity.badRequest().body(ApiResult.message(message))
    }

    fun serverError(message: String, errorReferenceCode: String): ResponseEntity<ApiResult> {
        return ResponseEntity.status(500).body(ApiResult.error(message, errorReferenceCode))
    }

    fun notFound(): ResponseEntity<ApiResult> {
        return ResponseEntity.notFound().build()
    }

    fun unauthenticated(): ResponseEntity<ApiResult> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    }

    fun forbidden(): ResponseEntity<ApiResult> {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
    }
}
