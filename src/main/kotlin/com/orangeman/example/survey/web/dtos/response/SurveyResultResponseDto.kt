package com.orangeman.example.survey.web.dtos.response

data class SurveyResultResponseDto(
    val questionId: Long,
    val title: String,
    val optionResults: List<OptionResult>
)

data class OptionResult(
    val optionId: Long,
    val title: String,
    val count: Int
)