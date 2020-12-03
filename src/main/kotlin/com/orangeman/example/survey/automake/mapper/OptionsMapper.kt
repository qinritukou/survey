/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.654+09:00
 */
package com.orangeman.example.survey.automake.mapper

import com.orangeman.example.survey.automake.domain.OptionsRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface OptionsMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    fun insert(insertStatement: InsertStatementProvider<OptionsRecord>): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insertMultiple")
    fun insertMultiple(multipleInsertStatement: MultiRowInsertStatementProvider<OptionsRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("OptionsRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): OptionsRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="OptionsRecordResult", value = [
        Result(column="option_id", property="optionId", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="question_id", property="questionId", jdbcType=JdbcType.BIGINT),
        Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        Result(column="created_by", property="createdBy", jdbcType=JdbcType.BIGINT),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="modified_by", property="modifiedBy", jdbcType=JdbcType.BIGINT),
        Result(column="modified_at", property="modifiedAt", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<OptionsRecord>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}