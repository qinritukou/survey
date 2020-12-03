/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.654+09:00
 */
package com.orangeman.example.survey.automake.mapper

import com.orangeman.example.survey.automake.domain.OptionsRecord
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options.createdAt
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options.createdBy
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options.modifiedAt
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options.modifiedBy
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options.optionId
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options.questionId
import com.orangeman.example.survey.automake.mapper.OptionsDynamicSqlSupport.Options.title
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun OptionsMapper.count(completer: CountCompleter) =
    countFrom(this::count, Options, completer)

fun OptionsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Options, completer)

fun OptionsMapper.deleteByPrimaryKey(optionId_: Long) =
    delete {
        where(optionId, isEqualTo(optionId_))
    }

fun OptionsMapper.insert(record: OptionsRecord) =
    insert(this::insert, record, Options) {
        map(optionId).toProperty("optionId")
        map(questionId).toProperty("questionId")
        map(title).toProperty("title")
        map(createdBy).toProperty("createdBy")
        map(createdAt).toProperty("createdAt")
        map(modifiedBy).toProperty("modifiedBy")
        map(modifiedAt).toProperty("modifiedAt")
    }

fun OptionsMapper.insertMultiple(records: Collection<OptionsRecord>) =
    insertMultiple(this::insertMultiple, records, Options) {
        map(optionId).toProperty("optionId")
        map(questionId).toProperty("questionId")
        map(title).toProperty("title")
        map(createdBy).toProperty("createdBy")
        map(createdAt).toProperty("createdAt")
        map(modifiedBy).toProperty("modifiedBy")
        map(modifiedAt).toProperty("modifiedAt")
    }

fun OptionsMapper.insertMultiple(vararg records: OptionsRecord) =
    insertMultiple(records.toList())

fun OptionsMapper.insertSelective(record: OptionsRecord) =
    insert(this::insert, record, Options) {
        map(optionId).toPropertyWhenPresent("optionId", record::optionId)
        map(questionId).toPropertyWhenPresent("questionId", record::questionId)
        map(title).toPropertyWhenPresent("title", record::title)
        map(createdBy).toPropertyWhenPresent("createdBy", record::createdBy)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(modifiedBy).toPropertyWhenPresent("modifiedBy", record::modifiedBy)
        map(modifiedAt).toPropertyWhenPresent("modifiedAt", record::modifiedAt)
    }

private val columnList = listOf(optionId, questionId, title, createdBy, createdAt, modifiedBy, modifiedAt)

fun OptionsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Options, completer)

fun OptionsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Options, completer)

fun OptionsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Options, completer)

fun OptionsMapper.selectByPrimaryKey(optionId_: Long) =
    selectOne {
        where(optionId, isEqualTo(optionId_))
    }

fun OptionsMapper.update(completer: UpdateCompleter) =
    update(this::update, Options, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: OptionsRecord) =
    apply {
        set(optionId).equalTo(record::optionId)
        set(questionId).equalTo(record::questionId)
        set(title).equalTo(record::title)
        set(createdBy).equalTo(record::createdBy)
        set(createdAt).equalTo(record::createdAt)
        set(modifiedBy).equalTo(record::modifiedBy)
        set(modifiedAt).equalTo(record::modifiedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: OptionsRecord) =
    apply {
        set(optionId).equalToWhenPresent(record::optionId)
        set(questionId).equalToWhenPresent(record::questionId)
        set(title).equalToWhenPresent(record::title)
        set(createdBy).equalToWhenPresent(record::createdBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(modifiedBy).equalToWhenPresent(record::modifiedBy)
        set(modifiedAt).equalToWhenPresent(record::modifiedAt)
    }

fun OptionsMapper.updateByPrimaryKey(record: OptionsRecord) =
    update {
        set(questionId).equalTo(record::questionId)
        set(title).equalTo(record::title)
        set(createdBy).equalTo(record::createdBy)
        set(createdAt).equalTo(record::createdAt)
        set(modifiedBy).equalTo(record::modifiedBy)
        set(modifiedAt).equalTo(record::modifiedAt)
        where(optionId, isEqualTo(record::optionId))
    }

fun OptionsMapper.updateByPrimaryKeySelective(record: OptionsRecord) =
    update {
        set(questionId).equalToWhenPresent(record::questionId)
        set(title).equalToWhenPresent(record::title)
        set(createdBy).equalToWhenPresent(record::createdBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(modifiedBy).equalToWhenPresent(record::modifiedBy)
        set(modifiedAt).equalToWhenPresent(record::modifiedAt)
        where(optionId, isEqualTo(record::optionId))
    }