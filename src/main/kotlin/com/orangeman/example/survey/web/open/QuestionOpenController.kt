package com.orangeman.example.survey.web.open

import com.orangeman.example.survey.domain.service.QuestionService
import com.orangeman.example.survey.web.dtos.response.QuestionResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/open/surveies/{surveyId}/questions")
class QuestionOpenController(
    private val questionService: QuestionService
) {

    @GetMapping()
    fun getQuestions(
            @PathVariable(value = "surveyId") surveyId: Long
    ): List<QuestionResponseDto> = questionService.findQuestionResponseDtosBySurveyId(surveyId)

}