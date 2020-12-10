package com.orangeman.example.survey.web.dtos.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

data class CreateAnswerRequestDto(
    val surveyId: Long,
    val username: String,
    val email: String,
    val options: List<Option>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Option(
    val questionId: Long,
    val optionId: Long
)