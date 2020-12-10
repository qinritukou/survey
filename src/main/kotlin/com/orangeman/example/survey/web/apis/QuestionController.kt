package com.orangeman.example.survey.web.apis

import com.orangeman.example.survey.config.authenticate.model.CurrentUser
import com.orangeman.example.survey.domain.model.user.SimpleUser
import com.orangeman.example.survey.domain.service.QuestionService
import com.orangeman.example.survey.web.dtos.request.CreateUpdateQuestionRequestDto
import com.orangeman.example.survey.web.dtos.response.QuestionResponseDto
import com.orangeman.example.survey.web.results.ApiResult
import com.orangeman.example.survey.web.results.ResponseResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/api/surveies/{surveyId}/questions")
class QuestionController(
    private val questionService: QuestionService
) {

    @GetMapping()
    fun getQuestions(
            @PathVariable(value = "surveyId") surveyId: Long
    ): List<QuestionResponseDto> = questionService.findQuestionResponseDtosBySurveyId(surveyId)

    @PostMapping()
    fun create(
            @CurrentUser currentUser: SimpleUser,
            @RequestBody createUpdateQuestionRequestDto: CreateUpdateQuestionRequestDto
    ): ResponseEntity<ApiResult> {
        return try {
            questionService.create(createUpdateQuestionRequestDto, currentUser.publisherId)
            ResponseResult.created()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

    @PutMapping("/{questionId}")
    fun update(
            @CurrentUser currentUser: SimpleUser,
            @RequestBody createUpdateQuestionRequestDto: CreateUpdateQuestionRequestDto
    ): ResponseEntity<ApiResult> {
        return try {
            questionService.update(createUpdateQuestionRequestDto, currentUser.publisherId)
            ResponseResult.updated()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

    @DeleteMapping("/{questionId}")
    fun del(
            @CurrentUser currentUser: SimpleUser,
            @PathVariable(value = "questionId") questionId: Long
    ): ResponseEntity<ApiResult> {
        return try {
            questionService.del(questionId)
            ResponseResult.deleted()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

}