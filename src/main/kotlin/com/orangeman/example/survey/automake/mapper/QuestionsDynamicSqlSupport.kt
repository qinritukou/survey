/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.652+09:00
 */
package com.orangeman.example.survey.automake.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object QuestionsDynamicSqlSupport {
    object Questions : SqlTable("questions") {
        val questionId = column<Long>("question_id", JDBCType.BIGINT)

        val title = column<String>("title", JDBCType.VARCHAR)

        val surveyId = column<Long>("survey_id", JDBCType.BIGINT)

        val createdBy = column<Long>("created_by", JDBCType.BIGINT)

        val createdAt = column<Date>("created_at", JDBCType.TIMESTAMP)

        val modifiedBy = column<Long>("modified_by", JDBCType.BIGINT)

        val modifiedAt = column<Date>("modified_at", JDBCType.TIMESTAMP)
    }
}