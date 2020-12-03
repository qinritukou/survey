/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.631+09:00
 */
package com.orangeman.example.survey.automake.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object PublishersDynamicSqlSupport {
    object Publishers : SqlTable("publishers") {
        val publisherId = column<Long>("publisher_id", JDBCType.BIGINT)

        val email = column<String>("email", JDBCType.CHAR)

        val password = column<String>("password", JDBCType.CHAR)

        val createdAt = column<Date>("created_at", JDBCType.TIMESTAMP)
    }
}