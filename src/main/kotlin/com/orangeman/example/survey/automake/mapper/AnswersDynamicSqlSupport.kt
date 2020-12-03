/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.656+09:00
 */
package com.orangeman.example.survey.automake.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object AnswersDynamicSqlSupport {
    object Answers : SqlTable("answers") {
        val answerId = column<Long>("answer_id", JDBCType.BIGINT)

        val audienceId = column<Long>("audience_id", JDBCType.BIGINT)

        val questionId = column<Long>("question_id", JDBCType.BIGINT)

        val optionId = column<Long>("option_id", JDBCType.BIGINT)
    }
}