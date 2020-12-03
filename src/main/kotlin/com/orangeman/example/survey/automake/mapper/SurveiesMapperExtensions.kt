/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.651+09:00
 */
package com.orangeman.example.survey.automake.mapper

import com.orangeman.example.survey.automake.domain.SurveiesRecord
import com.orangeman.example.survey.automake.mapper.SurveiesDynamicSqlSupport.Surveies
import com.orangeman.example.survey.automake.mapper.SurveiesDynamicSqlSupport.Surveies.createdAt
import com.orangeman.example.survey.automake.mapper.SurveiesDynamicSqlSupport.Surveies.createdBy
import com.orangeman.example.survey.automake.mapper.SurveiesDynamicSqlSupport.Surveies.modifiedAt
import com.orangeman.example.survey.automake.mapper.SurveiesDynamicSqlSupport.Surveies.modifiedBy
import com.orangeman.example.survey.automake.mapper.SurveiesDynamicSqlSupport.Surveies.surveyId
import com.orangeman.example.survey.automake.mapper.SurveiesDynamicSqlSupport.Surveies.title
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun SurveiesMapper.count(completer: CountCompleter) =
    countFrom(this::count, Surveies, completer)

fun SurveiesMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Surveies, completer)

fun SurveiesMapper.deleteByPrimaryKey(surveyId_: Long) =
    delete {
        where(surveyId, isEqualTo(surveyId_))
    }

fun SurveiesMapper.insert(record: SurveiesRecord) =
    insert(this::insert, record, Surveies) {
        map(surveyId).toProperty("surveyId")
        map(title).toProperty("title")
        map(createdBy).toProperty("createdBy")
        map(createdAt).toProperty("createdAt")
        map(modifiedBy).toProperty("modifiedBy")
        map(modifiedAt).toProperty("modifiedAt")
    }

fun SurveiesMapper.insertMultiple(records: Collection<SurveiesRecord>) =
    insertMultiple(this::insertMultiple, records, Surveies) {
        map(surveyId).toProperty("surveyId")
        map(title).toProperty("title")
        map(createdBy).toProperty("createdBy")
        map(createdAt).toProperty("createdAt")
        map(modifiedBy).toProperty("modifiedBy")
        map(modifiedAt).toProperty("modifiedAt")
    }

fun SurveiesMapper.insertMultiple(vararg records: SurveiesRecord) =
    insertMultiple(records.toList())

fun SurveiesMapper.insertSelective(record: SurveiesRecord) =
    insert(this::insert, record, Surveies) {
        map(surveyId).toPropertyWhenPresent("surveyId", record::surveyId)
        map(title).toPropertyWhenPresent("title", record::title)
        map(createdBy).toPropertyWhenPresent("createdBy", record::createdBy)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(modifiedBy).toPropertyWhenPresent("modifiedBy", record::modifiedBy)
        map(modifiedAt).toPropertyWhenPresent("modifiedAt", record::modifiedAt)
    }

private val columnList = listOf(surveyId, title, createdBy, createdAt, modifiedBy, modifiedAt)

fun SurveiesMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Surveies, completer)

fun SurveiesMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Surveies, completer)

fun SurveiesMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Surveies, completer)

fun SurveiesMapper.selectByPrimaryKey(surveyId_: Long) =
    selectOne {
        where(surveyId, isEqualTo(surveyId_))
    }

fun SurveiesMapper.update(completer: UpdateCompleter) =
    update(this::update, Surveies, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: SurveiesRecord) =
    apply {
        set(surveyId).equalTo(record::surveyId)
        set(title).equalTo(record::title)
        set(createdBy).equalTo(record::createdBy)
        set(createdAt).equalTo(record::createdAt)
        set(modifiedBy).equalTo(record::modifiedBy)
        set(modifiedAt).equalTo(record::modifiedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: SurveiesRecord) =
    apply {
        set(surveyId).equalToWhenPresent(record::surveyId)
        set(title).equalToWhenPresent(record::title)
        set(createdBy).equalToWhenPresent(record::createdBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(modifiedBy).equalToWhenPresent(record::modifiedBy)
        set(modifiedAt).equalToWhenPresent(record::modifiedAt)
    }

fun SurveiesMapper.updateByPrimaryKey(record: SurveiesRecord) =
    update {
        set(title).equalTo(record::title)
        set(createdBy).equalTo(record::createdBy)
        set(createdAt).equalTo(record::createdAt)
        set(modifiedBy).equalTo(record::modifiedBy)
        set(modifiedAt).equalTo(record::modifiedAt)
        where(surveyId, isEqualTo(record::surveyId))
    }

fun SurveiesMapper.updateByPrimaryKeySelective(record: SurveiesRecord) =
    update {
        set(title).equalToWhenPresent(record::title)
        set(createdBy).equalToWhenPresent(record::createdBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(modifiedBy).equalToWhenPresent(record::modifiedBy)
        set(modifiedAt).equalToWhenPresent(record::modifiedAt)
        where(surveyId, isEqualTo(record::surveyId))
    }