package com.orangeman.example.survey.domain.service

import com.orangeman.example.survey.automake.domain.SurveiesRecord
import com.orangeman.example.survey.domain.model.survey.SurveyNotExistException
import com.orangeman.example.survey.domain.repository.SurveyRepository
import com.orangeman.example.survey.web.dtos.request.CreateUpdateSurveyRequestDto
import com.orangeman.example.survey.web.dtos.response.SurveyResponseDto
import org.springframework.stereotype.Service

@Service
class SurveyService(
    private val surveyRepository: SurveyRepository
) {

    fun create(createUpdateSurveyRequestDto: CreateUpdateSurveyRequestDto, createdBy: Long): Int {
        val record = SurveiesRecord().also {
            it.title = createUpdateSurveyRequestDto.title
            it.createdBy = createdBy
        }
        return surveyRepository.create(record)
    }

    fun update(createUpdateSurveyRequestDto: CreateUpdateSurveyRequestDto, updatedBy: Long): Int {
        surveyRepository.findBySurveyId(createUpdateSurveyRequestDto.surveyId) ?: throw SurveyNotExistException()
        val record = SurveiesRecord().also {
            it.surveyId = createUpdateSurveyRequestDto.surveyId
            it.title = createUpdateSurveyRequestDto.title
            it.modifiedBy = updatedBy
        }
        return surveyRepository.update(record)
    }

    fun del(surveyId: Long, createdBy: Long): Int {
        surveyRepository.findBySurveyIdAndCreatedBy(surveyId, createdBy) ?: throw SurveyNotExistException()
        return surveyRepository.del(surveyId)
    }

    fun findByCreatedBy(createdBy: Long): List<SurveyResponseDto> {
        val recordList = surveyRepository.findByCreatedBy(createdBy)
        return recordList.map {
            SurveyResponseDto(
                surveyId = it.surveyId!!,
                title = it.title!!
            )
        }
    }

    fun findBySurveyId(surveyId: Long): SurveyResponseDto {
        val record = surveyRepository.findBySurveyId(surveyId) ?: throw SurveyNotExistException()
        return SurveyResponseDto(
            surveyId = record.surveyId!!,
            title = record.title!!
        )
    }

}