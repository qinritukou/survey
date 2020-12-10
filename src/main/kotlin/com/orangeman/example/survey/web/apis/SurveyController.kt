package com.orangeman.example.survey.web.apis

import com.orangeman.example.survey.config.authenticate.model.CurrentUser
import com.orangeman.example.survey.domain.model.user.SimpleUser
import com.orangeman.example.survey.domain.service.AnswerService
import com.orangeman.example.survey.domain.service.SurveyService
import com.orangeman.example.survey.web.dtos.request.CreateUpdateSurveyRequestDto
import com.orangeman.example.survey.web.dtos.response.SurveyResponseDto
import com.orangeman.example.survey.web.dtos.response.SurveyResultResponseDto
import com.orangeman.example.survey.web.results.ApiResult
import com.orangeman.example.survey.web.results.ResponseResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/surveies")
class SurveyController(
    private val surveyService: SurveyService,
    private val answerService: AnswerService
) {

    @GetMapping()
    fun getSurvies(
            @CurrentUser currentUser: SimpleUser
    ): List<SurveyResponseDto> = surveyService.findByCreatedBy(currentUser.publisherId)

    @GetMapping("/{surveyId}")
    fun getSurvey(
            @PathVariable(value = "surveyId") surveyId: Long,
    ): SurveyResponseDto = surveyService.findBySurveyId(surveyId)


    @GetMapping("/{surveyId}/result")
    fun getSurveyResults(
            @PathVariable(value = "surveyId") surveyId: Long,
    ): List<SurveyResultResponseDto> = answerService.getSurveyResultResponseDto(surveyId)

    @PostMapping()
    fun create(
            @CurrentUser currentUser: SimpleUser,
            @RequestBody createUpdateSurveyRequestDto: CreateUpdateSurveyRequestDto
    ): ResponseEntity<ApiResult> {
        return try {
            surveyService.create(createUpdateSurveyRequestDto, currentUser.publisherId)
            ResponseResult.created()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

    @PutMapping("/{surveyId}")
    fun update(
            @CurrentUser currentUser: SimpleUser,
            @RequestBody createUpdateSurveyRequestDto: CreateUpdateSurveyRequestDto
    ): ResponseEntity<ApiResult> {
        return try {
            surveyService.update(createUpdateSurveyRequestDto, currentUser.publisherId)
            ResponseResult.updated()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

    @DeleteMapping("/{surveyId}")
    fun del(
            @CurrentUser currentUser: SimpleUser,
            @PathVariable(value = "surveyId") surveyId: Long,
    ): ResponseEntity<ApiResult> {
        return try {
            surveyService.del(surveyId, currentUser.publisherId)
            ResponseResult.deleted()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }


}