package com.orangeman.example.survey.domain.repository

import com.orangeman.example.survey.automake.domain.AnswersRecord
import com.orangeman.example.survey.automake.mapper.AnswersMapper
import com.orangeman.example.survey.automake.mapper.insertSelective
import org.springframework.stereotype.Repository

@Repository
class AnswerRepository(
    private val answersMapper: AnswersMapper
) {

    fun create(answersRecord: AnswersRecord): Int {
        return answersMapper.insertSelective(answersRecord)
    }

}