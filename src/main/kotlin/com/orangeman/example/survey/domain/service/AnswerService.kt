package com.orangeman.example.survey.domain.service

import com.orangeman.example.survey.automake.domain.AnswersRecord
import com.orangeman.example.survey.automake.domain.AudiencesRecord
import com.orangeman.example.survey.domain.repository.AnswerRepository
import com.orangeman.example.survey.domain.repository.AudienceRepository
import com.orangeman.example.survey.domain.repository.OptionRepository
import com.orangeman.example.survey.domain.repository.QuestionRepository
import com.orangeman.example.survey.web.dtos.request.CreateAnswerRequestDto
import com.orangeman.example.survey.web.dtos.response.OptionResult
import com.orangeman.example.survey.web.dtos.response.SurveyResultResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception

@Service
class AnswerService(
    private val answerRepository: AnswerRepository,
    private val audienceRepository: AudienceRepository,
    private val questionRepository: QuestionRepository,
    private val optionRepository: OptionRepository
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

    fun getSurveyResultResponseDto(surveyId: Long): List<SurveyResultResponseDto> {
        val questions = questionRepository.findBySurveyId(surveyId)
        val questionIds = questions.map { it.questionId!! }
        val options = optionRepository.findByQuestionIds(questionIds)
        val answers = answerRepository.findByQuestionIds(questionIds)

        val results = questions.map { question ->
            val optionResults = options.filter { it.questionId == question.questionId }.map { thisOption ->
                val count = answers.filter { it.optionId == thisOption.optionId }.size
                OptionResult(
                    optionId = thisOption.optionId!!,
                    title = thisOption.title!!,
                    count = count
                )
            }
            SurveyResultResponseDto(
                questionId = question.questionId!!,
                title = question.title!!,
                optionResults = optionResults as List<OptionResult>
            )
        }
        return results
    }


}