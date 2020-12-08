package com.orangeman.example.survey.config.authenticate.model

import org.springframework.security.core.annotation.AuthenticationPrincipal
import java.lang.annotation.*
import java.lang.annotation.Retention
import java.lang.annotation.Target

@Target(ElementType.PARAMETER, ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
annotation class CurrentUser()
