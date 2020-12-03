/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.655+09:00
 */
package com.orangeman.example.survey.automake.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object AudiencesDynamicSqlSupport {
    object Audiences : SqlTable("audiences") {
        val audienceId = column<Long>("audience_id", JDBCType.BIGINT)

        val surveyId = column<Long>("survey_id", JDBCType.BIGINT)

        val nickname = column<String>("nickname", JDBCType.VARCHAR)

        val email = column<String>("email", JDBCType.VARCHAR)

        val createdAt = column<Date>("created_at", JDBCType.TIMESTAMP)
    }
}