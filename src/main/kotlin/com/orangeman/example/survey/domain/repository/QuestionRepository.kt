package com.orangeman.example.survey.domain.repository

import com.orangeman.example.survey.automake.domain.QuestionsRecord
import com.orangeman.example.survey.automake.mapper.*
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.springframework.stereotype.Repository

@Repository
class QuestionRepository(
    private val questionsMapper: QuestionsMapper
) {

    fun create(questionsRecord: QuestionsRecord): Int {
        return questionsMapper.insertSelective(questionsRecord)
    }

    fun update(questionsRecord: QuestionsRecord): Int {
        return questionsMapper.updateByPrimaryKeySelective(questionsRecord)
    }

    fun del(questionId: Long): Int {
        return questionsMapper.deleteByPrimaryKey(questionId)
    }

    fun findBySurveyId(surveyId: Long): List<QuestionsRecord> = selectList(
        questionsMapper::selectMany,
        listOf(
            QuestionsDynamicSqlSupport.Questions.surveyId,
            QuestionsDynamicSqlSupport.Questions.questionId,
            QuestionsDynamicSqlSupport.Questions.title,
            QuestionsDynamicSqlSupport.Questions.createdBy,
        ),
        QuestionsDynamicSqlSupport.Questions
    ) {
        where(QuestionsDynamicSqlSupport.Questions.surveyId, SqlBuilder.isEqualTo(surveyId))
    }

}