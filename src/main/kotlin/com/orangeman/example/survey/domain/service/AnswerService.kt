package com.orangeman.example.survey.domain.service

import com.orangeman.example.survey.automake.domain.AnswersRecord
import com.orangeman.example.survey.automake.domain.AudiencesRecord
import com.orangeman.example.survey.domain.repository.AnswerRepository
import com.orangeman.example.survey.domain.repository.AudienceRepository
import com.orangeman.example.survey.web.dtos.request.CreateAnswerRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception

@Service
class AnswerService(
    private val answerRepository: AnswerRepository,
    private val audienceRepository: AudienceRepository
) {

    @Transactional
    fun create(createAnswerRequestDto: CreateAnswerRequestDto) {
        audienceRepository.create(AudiencesRecord(
            surveyId = createAnswerRequestDto.surveyId,
            nickname = createAnswerRequestDto.username,
            email = createAnswerRequestDto.email
        ))
        val audience = audienceRepository.findByEmailAndSurveyId(createAnswerRequestDto.email, createAnswerRequestDto.surveyId) ?: throw Exception("No audience found")
        createAnswerRequestDto.options.map { option ->
            val record = AnswersRecord(
                audienceId = audience.audienceId,
                questionId = option.questionId,
                optionId = option.optionId
            )
            val result = answerRepository.create(record)
            if (result == 0) throw Exception("Insert answer failed")
        }
    }


}