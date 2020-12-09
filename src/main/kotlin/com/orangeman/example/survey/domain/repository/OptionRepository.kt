package com.orangeman.example.survey.domain.repository

import com.orangeman.example.survey.automake.domain.OptionsRecord
import com.orangeman.example.survey.automake.domain.QuestionsRecord
import com.orangeman.example.survey.automake.mapper.*
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.springframework.stereotype.Repository

@Repository
class OptionRepository(
    val optionsMapper: OptionsMapper
) {

    fun create(optionsRecord: OptionsRecord): Int {
        return optionsMapper.insertSelective(optionsRecord)
    }

    fun update(optionsRecord: OptionsRecord): Int {
        return optionsMapper.updateByPrimaryKeySelective(optionsRecord)
    }

    fun del(optionId: Long): Int {
        return optionsMapper.deleteByPrimaryKey(optionId)
    }

    fun findByQuestionIds(questionIds: List<Long>): List<OptionsRecord> =
        if (questionIds.isEmpty()) emptyList() else selectList(
            optionsMapper::selectMany,
            listOf(
                OptionsDynamicSqlSupport.Options.questionId,
                OptionsDynamicSqlSupport.Options.optionId,
                OptionsDynamicSqlSupport.Options.title,
                OptionsDynamicSqlSupport.Options.createdBy,
            ),
                OptionsDynamicSqlSupport.Options
        ) {
            where(QuestionsDynamicSqlSupport.Questions.questionId, SqlBuilder.isIn(questionIds))
        }


}