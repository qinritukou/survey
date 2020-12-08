package com.orangeman.example.survey.web.apis.dtos.request

data class CreateUpdateSurveyRequestDto(
    val surveyId: Long,
    val title: String
)