package com.orangeman.example.survey.domain.repository

import com.orangeman.example.survey.automake.domain.AnswersRecord
import com.orangeman.example.survey.automake.mapper.AnswersDynamicSqlSupport
import com.orangeman.example.survey.automake.mapper.AnswersMapper
import com.orangeman.example.survey.automake.mapper.insertSelective
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.springframework.stereotype.Repository

@Repository
class AnswerRepository(
    private val answersMapper: AnswersMapper
) {

    fun create(answersRecord: AnswersRecord): Int {
        return answersMapper.insertSelective(answersRecord)
    }

    fun findByQuestionIds(questionIds: List<Long>): List<AnswersRecord> =
        if (questionIds.isEmpty()) emptyList() else selectList(
                answersMapper::selectMany,
                listOf(
                        AnswersDynamicSqlSupport.Answers.audienceId,
                        AnswersDynamicSqlSupport.Answers.questionId,
                        AnswersDynamicSqlSupport.Answers.optionId,
                ),
                AnswersDynamicSqlSupport.Answers
        ) {
            where(AnswersDynamicSqlSupport.Answers.questionId, SqlBuilder.isIn(questionIds))
        }
}