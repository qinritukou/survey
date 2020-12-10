package com.orangeman.example.survey.domain.service

import com.orangeman.example.survey.automake.domain.OptionsRecord
import com.orangeman.example.survey.domain.repository.OptionRepository
import com.orangeman.example.survey.web.dtos.request.CreateOptionRequestionDto
import org.springframework.stereotype.Service

@Service
class OptionService(
    private val optionRepository: OptionRepository
) {

    fun create(createOptionRequestionDto: CreateOptionRequestionDto, createdBy: Long) {
        optionRepository.create(OptionsRecord(
            questionId = createOptionRequestionDto.questionId,
            title = createOptionRequestionDto.title,
            createdBy = createdBy
        ))
    }

    fun del(questionId: Long): Int {
        return optionRepository.del(questionId)
    }

}