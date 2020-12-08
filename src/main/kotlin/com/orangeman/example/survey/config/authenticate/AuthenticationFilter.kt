package com.orangeman.example.survey.config.authenticate

import com.fasterxml.jackson.databind.ObjectMapper
import com.orangeman.example.survey.config.authenticate.model.LoginRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.InsufficientAuthenticationException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class AuthenticationFilter(
    private val authenticationSuccessHandler: AuthenticationSuccessHandler,
    private val authenticationFailureHandler: AuthenticationFailureHandler,
    private val objectMapper: ObjectMapper,
    private val passwordEncoder: PasswordEncoder
): AbstractAuthenticationProcessingFilter(
    AntPathRequestMatcher("/api/authentications", "POST")
) {

    @Autowired
    override fun setAuthenticationManager(authenticationManager: AuthenticationManager) {
        super.setAuthenticationManager(authenticationManager)
    }

    @Autowired
    override fun setAuthenticationSuccessHandler(successHandler: AuthenticationSuccessHandler) {
        super.setAuthenticationSuccessHandler(authenticationSuccessHandler)
    }

    @Autowired
    override fun setAuthenticationFailureHandler(failureHandler: AuthenticationFailureHandler?) {
        super.setAuthenticationFailureHandler(authenticationFailureHandler)
    }

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        log.debug("Processing login request")

        val requestBody = request.reader.readLine()
        val loginRequest = objectMapper.readValue(requestBody, LoginRequest::class.java)
        if (loginRequest.isValid()) {
            throw InsufficientAuthenticationException("Invalid authentication request")
        }

        val token = UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        return authenticationManager.authenticate(token)
    }

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }
}