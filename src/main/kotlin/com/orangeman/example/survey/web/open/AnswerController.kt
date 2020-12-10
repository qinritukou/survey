package com.orangeman.example.survey.web.open

import com.orangeman.example.survey.domain.service.AnswerService
import com.orangeman.example.survey.web.dtos.request.CreateAnswerRequestDto
import com.orangeman.example.survey.web.results.ApiResult
import com.orangeman.example.survey.web.results.ResponseResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/open/answers")
class AnswerController(
    private val answerService: AnswerService
) {

    @PostMapping()
    fun create(
            @RequestBody createAnswerRequestDto: CreateAnswerRequestDto
    ): ResponseEntity<ApiResult> {
        return try {
            answerService.create(createAnswerRequestDto)
            ResponseResult.created()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }


}