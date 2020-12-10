package com.orangeman.example.survey.web.dtos.request

data class CreateUpdateQuestionRequestDto(
    val surveyId: Long,
    val questionId: Long,
    val title: String,
)
