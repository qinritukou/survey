package com.orangeman.example.survey.web.apis

import com.orangeman.example.survey.domain.service.UserService
import com.orangeman.example.survey.web.apis.dtos.request.RegistrationRequestDto
import com.orangeman.example.survey.web.results.ApiResult
import com.orangeman.example.survey.web.results.ResponseResult
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegistrationApiController(
    private val userService: UserService
) {

    @PostMapping("/api/registrations")
    fun register(
        @Validated @RequestBody registrationRequestDto: RegistrationRequestDto
    ): ResponseEntity<ApiResult> {
        return try {
            userService.register(registrationRequestDto)
            ResponseResult.created()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

}