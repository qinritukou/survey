package com.orangeman.example.survey.domain.service

import com.orangeman.example.survey.automake.domain.QuestionsRecord
import com.orangeman.example.survey.domain.repository.OptionRepository
import com.orangeman.example.survey.domain.repository.QuestionRepository
import com.orangeman.example.survey.web.dtos.request.CreateUpdateQuestionRequestDto
import com.orangeman.example.survey.web.dtos.response.Option
import com.orangeman.example.survey.web.dtos.response.QuestionResponseDto
import org.springframework.stereotype.Service

@Service
class QuestionService(
    private val questionRepository: QuestionRepository,
    private val optionRepository: OptionRepository
) {

    fun create(createUpdateQuestionRequestDto: CreateUpdateQuestionRequestDto, publisherId: Long): Int {
        return questionRepository.create(QuestionsRecord(
            surveyId = createUpdateQuestionRequestDto.surveyId,
            title = createUpdateQuestionRequestDto.title,
            createdBy = publisherId
        ))
    }

    fun update(createUpdateQuestionRequestDto: CreateUpdateQuestionRequestDto, updatedBy: Long): Int {
        return questionRepository.update(QuestionsRecord(
            questionId = createUpdateQuestionRequestDto.questionId,
            surveyId = createUpdateQuestionRequestDto.surveyId,
            title = createUpdateQuestionRequestDto.title,
            modifiedBy = updatedBy
        ))
    }

    fun del(questionId: Long): Int {
        return questionRepository.del(questionId)
    }

    fun findQuestionResponseDtosBySurveyId(surveyId: Long): List<QuestionResponseDto> {
        val questions = questionRepository.findBySurveyId(surveyId)
        val options = optionRepository.findByQuestionIds(questionIds = questions.map { it.questionId!! })
        return questions.map { questionsRecord ->
            QuestionResponseDto(
                surveyId = questionsRecord.surveyId!!,
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