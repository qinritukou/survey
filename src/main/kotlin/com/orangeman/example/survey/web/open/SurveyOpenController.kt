package com.orangeman.example.survey.web.open

import com.orangeman.example.survey.domain.service.SurveyService
import com.orangeman.example.survey.web.dtos.response.SurveyResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/open/surveies")
class SurveyOpenController(
    private val surveyService: SurveyService
) {

    @GetMapping("/{surveyId}")
    fun getSurvey(
            @PathVariable(value = "surveyId") surveyId: Long,
    ): SurveyResponseDto = surveyService.findBySurveyId(surveyId)

}