package com.orangeman.example.survey.config.authenticate

import com.fasterxml.jackson.databind.ObjectMapper
import com.orangeman.example.survey.web.results.ApiResult
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.InsufficientAuthenticationException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SimpleAuthenticationFailureHandler(
    private val objectMapper: ObjectMapper
) : AuthenticationFailureHandler {

    override fun onAuthenticationFailure(request: HttpServletRequest, response: HttpServletResponse, exception: AuthenticationException) {
        response.status = HttpStatus.BAD_REQUEST.value()
        val failure = when (exception) {
            is BadCredentialsException -> ApiResult.message("")
            is InsufficientAuthenticationException -> ApiResult.message("Invalid authentication request")
            else -> ApiResult.message("Authentication failure")
        }
        objectMapper.writeValue(response.writer, failure)
    }
}