package com.orangeman.example.survey.web.apis

import com.orangeman.example.survey.config.authenticate.model.CurrentUser
import com.orangeman.example.survey.domain.model.user.SimpleUser
import com.orangeman.example.survey.domain.service.OptionService
import com.orangeman.example.survey.web.dtos.request.CreateOptionRequestionDto
import com.orangeman.example.survey.web.results.ApiResult
import com.orangeman.example.survey.web.results.ResponseResult
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/api/surveies/{surveyId}/questions/{questionId}/options")
class OptionController(
    private val optionService: OptionService
) {

    @PostMapping()
    fun create(
            @CurrentUser currentUser: SimpleUser,
            @RequestBody createOptionRequestionDto: CreateOptionRequestionDto
    ): ResponseEntity<ApiResult> {
        return try {
            optionService.create(createOptionRequestionDto, currentUser.publisherId)
            ResponseResult.created()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

    @DeleteMapping("/{optionId}")
    fun del(
            @CurrentUser currentUser: SimpleUser,
            @PathVariable(value = "optionId") optionId: Long
    ): ResponseEntity<ApiResult> {
        return try {
            optionService.del(optionId)
            ResponseResult.deleted()
        } catch (e: Exception) {
            ResponseResult.failure(e.message!!)
        }
    }

}