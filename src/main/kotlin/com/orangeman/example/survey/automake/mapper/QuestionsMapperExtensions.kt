/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.652+09:00
 */
package com.orangeman.example.survey.automake.mapper

import com.orangeman.example.survey.automake.domain.QuestionsRecord
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions.createdAt
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions.createdBy
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions.modifiedAt
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions.modifiedBy
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions.questionId
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions.surveyId
import com.orangeman.example.survey.automake.mapper.QuestionsDynamicSqlSupport.Questions.title
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun QuestionsMapper.count(completer: CountCompleter) =
    countFrom(this::count, Questions, completer)

fun QuestionsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Questions, completer)

fun QuestionsMapper.deleteByPrimaryKey(questionId_: Long) =
    delete {
        where(questionId, isEqualTo(questionId_))
    }

fun QuestionsMapper.insert(record: QuestionsRecord) =
    insert(this::insert, record, Questions) {
        map(questionId).toProperty("questionId")
        map(title).toProperty("title")
        map(surveyId).toProperty("surveyId")
        map(createdBy).toProperty("createdBy")
        map(createdAt).toProperty("createdAt")
        map(modifiedBy).toProperty("modifiedBy")
        map(modifiedAt).toProperty("modifiedAt")
    }

fun QuestionsMapper.insertMultiple(records: Collection<QuestionsRecord>) =
    insertMultiple(this::insertMultiple, records, Questions) {
        map(questionId).toProperty("questionId")
        map(title).toProperty("title")
        map(surveyId).toProperty("surveyId")
        map(createdBy).toProperty("createdBy")
        map(createdAt).toProperty("createdAt")
        map(modifiedBy).toProperty("modifiedBy")
        map(modifiedAt).toProperty("modifiedAt")
    }

fun QuestionsMapper.insertMultiple(vararg records: QuestionsRecord) =
    insertMultiple(records.toList())

fun QuestionsMapper.insertSelective(record: QuestionsRecord) =
    insert(this::insert, record, Questions) {
        map(questionId).toPropertyWhenPresent("questionId", record::questionId)
        map(title).toPropertyWhenPresent("title", record::title)
        map(surveyId).toPropertyWhenPresent("surveyId", record::surveyId)
        map(createdBy).toPropertyWhenPresent("createdBy", record::createdBy)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(modifiedBy).toPropertyWhenPresent("modifiedBy", record::modifiedBy)
        map(modifiedAt).toPropertyWhenPresent("modifiedAt", record::modifiedAt)
    }

private val columnList = listOf(questionId, title, surveyId, createdBy, createdAt, modifiedBy, modifiedAt)

fun QuestionsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Questions, completer)

fun QuestionsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Questions, completer)

fun QuestionsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Questions, completer)

fun QuestionsMapper.selectByPrimaryKey(questionId_: Long) =
    selectOne {
        where(questionId, isEqualTo(questionId_))
    }

fun QuestionsMapper.update(completer: UpdateCompleter) =
    update(this::update, Questions, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: QuestionsRecord) =
    apply {
        set(questionId).equalTo(record::questionId)
        set(title).equalTo(record::title)
        set(surveyId).equalTo(record::surveyId)
        set(createdBy).equalTo(record::createdBy)
        set(createdAt).equalTo(record::createdAt)
        set(modifiedBy).equalTo(record::modifiedBy)
        set(modifiedAt).equalTo(record::modifiedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: QuestionsRecord) =
    apply {
        set(questionId).equalToWhenPresent(record::questionId)
        set(title).equalToWhenPresent(record::title)
        set(surveyId).equalToWhenPresent(record::surveyId)
        set(createdBy).equalToWhenPresent(record::createdBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(modifiedBy).equalToWhenPresent(record::modifiedBy)
        set(modifiedAt).equalToWhenPresent(record::modifiedAt)
    }

fun QuestionsMapper.updateByPrimaryKey(record: QuestionsRecord) =
    update {
        set(title).equalTo(record::title)
        set(surveyId).equalTo(record::surveyId)
        set(createdBy).equalTo(record::createdBy)
        set(createdAt).equalTo(record::createdAt)
        set(modifiedBy).equalTo(record::modifiedBy)
        set(modifiedAt).equalTo(record::modifiedAt)
        where(questionId, isEqualTo(record::questionId))
    }

fun QuestionsMapper.updateByPrimaryKeySelective(record: QuestionsRecord) =
    update {
        set(title).equalToWhenPresent(record::title)
        set(surveyId).equalToWhenPresent(record::surveyId)
        set(createdBy).equalToWhenPresent(record::createdBy)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(modifiedBy).equalToWhenPresent(record::modifiedBy)
        set(modifiedAt).equalToWhenPresent(record::modifiedAt)
        where(questionId, isEqualTo(record::questionId))
    }