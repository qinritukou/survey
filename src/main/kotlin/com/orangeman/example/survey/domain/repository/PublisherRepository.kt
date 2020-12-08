package com.orangeman.example.survey.domain.repository

import com.orangeman.example.survey.automake.domain.PublishersRecord
import com.orangeman.example.survey.automake.mapper.PublishersDynamicSqlSupport.Publishers
import com.orangeman.example.survey.automake.mapper.PublishersMapper
import com.orangeman.example.survey.automake.mapper.insert
import com.orangeman.example.survey.automake.mapper.insertSelective
import com.orangeman.example.survey.domain.model.user.UsernameExistsException
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class PublisherRepository(
    private val publishersMapper: PublishersMapper,
    private val passwordEncoder: PasswordEncoder
) {

    fun register(email: String, password: String): PublishersRecord {
        val existPublisher = findByEmail(email)
        if (existPublisher != null) throw UsernameExistsException()

        val publisher = PublishersRecord(
            email = email,
            password = passwordEncoder.encode(password)
        )
        publishersMapper.insertSelective(publisher)
        return publisher
    }

    fun findByEmail(email: String): PublishersRecord? = selectList(
        publishersMapper::selectMany,
        listOf(
            Publishers.publisherId,
            Publishers.email,
            Publishers.password
        ),
        Publishers
    ) {
        where(Publishers.email, isEqualTo(email))
    }.firstOrNull()


}