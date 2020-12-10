package com.orangeman.example.survey.web.dtos.response

data class QuestionResponseDto(
    val surveyId: Long,
    val questionId: Long,
    val title: String,
    val options: List<Option>
)

data class Option(
    val optionId: Long,
    val title: String
)