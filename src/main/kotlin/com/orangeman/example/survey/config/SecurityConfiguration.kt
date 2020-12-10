package com.orangeman.example.survey.config

import com.orangeman.example.survey.config.authenticate.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler


@EnableWebSecurity
class SecurityConfiguration(
        private val authenticationFilter: AuthenticationFilter,
        private val logoutSuccessHandler: LogoutSuccessHandler
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
                .antMatchers(*PUBLIC).permitAll()
                .anyRequest().authenticated()
            .and()
                .addFilterAt(authenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
                .formLogin()
                .loginPage("/login")
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
            .and()
                .csrf().disable()
    }

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(*STATIC_IGNORING)
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager? {
        return super.authenticationManagerBean()
    }

    companion object {
        val STATIC_IGNORING = arrayOf("/static/**", "/js/**", "/css/**", "/images/**", "/favicon.ico")
        val PUBLIC = arrayOf("/error", "/login", "/logout", "/register", "/api/registrations",
                "/api/open/surveies", "/api/open/surveies/**",
                "/api/open/surveies/**/questions",
                "/api/open/answers")
    }

}