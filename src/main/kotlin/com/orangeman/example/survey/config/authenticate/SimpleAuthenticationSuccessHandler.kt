package com.orangeman.example.survey.config.authenticate

import com.fasterxml.jackson.databind.ObjectMapper
import com.orangeman.example.survey.web.results.ApiResult
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SimpleAuthenticationSuccessHandler(
    private val objectMapper: ObjectMapper
) : AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
        response.status = HttpStatus.OK.value()
        objectMapper.writeValue(response.writer, ApiResult.message("authenticated"))
    }
}