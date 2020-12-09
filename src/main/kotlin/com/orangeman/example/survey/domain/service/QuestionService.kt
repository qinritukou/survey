package com.orangeman.example.survey.domain.service

import com.orangeman.example.survey.domain.repository.OptionRepository
import com.orangeman.example.survey.domain.repository.QuestionRepository
import com.orangeman.example.survey.web.apis.dtos.response.Option
import com.orangeman.example.survey.web.apis.dtos.response.QuestionResponseDto
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
    private val optionRepository: OptionRepository
) {

    fun findQuestionResponseDtosBySurveyId(surveyId: Long): List<QuestionResponseDto> {
        val questions = questionRepository.findBySurveyId(surveyId)
        val options = optionRepository.findByQuestionIds(questionIds = questions.map { it.questionId!! })
        return questions.map { questionsRecord ->
            QuestionResponseDto(
                questionId = questionsRecord.questionId!!,
                title = questionsRecord.title!!,
                options = options.filter { it.questionId == questionsRecord.questionId }
                        .map { optionsRecord ->
                            Option(
                                optionId =optionsRecord.optionId!!,
                                title = optionsRecord.title!!
                            )
                        }
            )
        }
    }
}