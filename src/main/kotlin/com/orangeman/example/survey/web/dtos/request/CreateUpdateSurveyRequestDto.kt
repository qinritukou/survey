package com.orangeman.example.survey.web.dtos.request

data class CreateUpdateSurveyRequestDto(
    val surveyId: Long,
    val title: String
)