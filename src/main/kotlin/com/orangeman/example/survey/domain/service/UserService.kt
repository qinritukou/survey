package com.orangeman.example.survey.domain.service

import com.orangeman.example.survey.domain.model.user.SimpleUser
import com.orangeman.example.survey.domain.model.user.UsernameNotFoundException
import com.orangeman.example.survey.domain.repository.PublisherRepository
import com.orangeman.example.survey.web.apis.dtos.request.RegistrationRequestDto
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val publisherRepository: PublisherRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        if (username.isBlank()) throw UsernameNotFoundException()
        val publisher = publisherRepository.findByEmail(username) ?: throw UsernameNotFoundException()
        return SimpleUser(
            publisherId = publisher.publisherId!!,
            email = publisher.email!!,
            pass = publisher.password!!
        )
    }

    fun register(registrationRequestDto: RegistrationRequestDto) {
        publisherRepository.register(registrationRequestDto.email, registrationRequestDto.password)
    }


}