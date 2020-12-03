/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.657+09:00
 */
package com.orangeman.example.survey.automake.mapper

import com.orangeman.example.survey.automake.domain.AnswersRecord
import com.orangeman.example.survey.automake.mapper.AnswersDynamicSqlSupport.Answers
import com.orangeman.example.survey.automake.mapper.AnswersDynamicSqlSupport.Answers.answerId
import com.orangeman.example.survey.automake.mapper.AnswersDynamicSqlSupport.Answers.audienceId
import com.orangeman.example.survey.automake.mapper.AnswersDynamicSqlSupport.Answers.optionId
import com.orangeman.example.survey.automake.mapper.AnswersDynamicSqlSupport.Answers.questionId
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun AnswersMapper.count(completer: CountCompleter) =
    countFrom(this::count, Answers, completer)

fun AnswersMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Answers, completer)

fun AnswersMapper.deleteByPrimaryKey(answerId_: Long) =
    delete {
        where(answerId, isEqualTo(answerId_))
    }

fun AnswersMapper.insert(record: AnswersRecord) =
    insert(this::insert, record, Answers) {
        map(answerId).toProperty("answerId")
        map(audienceId).toProperty("audienceId")
        map(questionId).toProperty("questionId")
        map(optionId).toProperty("optionId")
    }

fun AnswersMapper.insertMultiple(records: Collection<AnswersRecord>) =
    insertMultiple(this::insertMultiple, records, Answers) {
        map(answerId).toProperty("answerId")
        map(audienceId).toProperty("audienceId")
        map(questionId).toProperty("questionId")
        map(optionId).toProperty("optionId")
    }

fun AnswersMapper.insertMultiple(vararg records: AnswersRecord) =
    insertMultiple(records.toList())

fun AnswersMapper.insertSelective(record: AnswersRecord) =
    insert(this::insert, record, Answers) {
        map(answerId).toPropertyWhenPresent("answerId", record::answerId)
        map(audienceId).toPropertyWhenPresent("audienceId", record::audienceId)
        map(questionId).toPropertyWhenPresent("questionId", record::questionId)
        map(optionId).toPropertyWhenPresent("optionId", record::optionId)
    }

private val columnList = listOf(answerId, audienceId, questionId, optionId)

fun AnswersMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Answers, completer)

fun AnswersMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Answers, completer)

fun AnswersMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Answers, completer)

fun AnswersMapper.selectByPrimaryKey(answerId_: Long) =
    selectOne {
        where(answerId, isEqualTo(answerId_))
    }

fun AnswersMapper.update(completer: UpdateCompleter) =
    update(this::update, Answers, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: AnswersRecord) =
    apply {
        set(answerId).equalTo(record::answerId)
        set(audienceId).equalTo(record::audienceId)
        set(questionId).equalTo(record::questionId)
        set(optionId).equalTo(record::optionId)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: AnswersRecord) =
    apply {
        set(answerId).equalToWhenPresent(record::answerId)
        set(audienceId).equalToWhenPresent(record::audienceId)
        set(questionId).equalToWhenPresent(record::questionId)
        set(optionId).equalToWhenPresent(record::optionId)
    }

fun AnswersMapper.updateByPrimaryKey(record: AnswersRecord) =
    update {
        set(audienceId).equalTo(record::audienceId)
        set(questionId).equalTo(record::questionId)
        set(optionId).equalTo(record::optionId)
        where(answerId, isEqualTo(record::answerId))
    }

fun AnswersMapper.updateByPrimaryKeySelective(record: AnswersRecord) =
    update {
        set(audienceId).equalToWhenPresent(record::audienceId)
        set(questionId).equalToWhenPresent(record::questionId)
        set(optionId).equalToWhenPresent(record::optionId)
        where(answerId, isEqualTo(record::answerId))
    }