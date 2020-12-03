/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.656+09:00
 */
package com.orangeman.example.survey.automake.mapper

import com.orangeman.example.survey.automake.domain.AudiencesRecord
import com.orangeman.example.survey.automake.mapper.AudiencesDynamicSqlSupport.Audiences
import com.orangeman.example.survey.automake.mapper.AudiencesDynamicSqlSupport.Audiences.audienceId
import com.orangeman.example.survey.automake.mapper.AudiencesDynamicSqlSupport.Audiences.createdAt
import com.orangeman.example.survey.automake.mapper.AudiencesDynamicSqlSupport.Audiences.email
import com.orangeman.example.survey.automake.mapper.AudiencesDynamicSqlSupport.Audiences.nickname
import com.orangeman.example.survey.automake.mapper.AudiencesDynamicSqlSupport.Audiences.surveyId
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun AudiencesMapper.count(completer: CountCompleter) =
    countFrom(this::count, Audiences, completer)

fun AudiencesMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Audiences, completer)

fun AudiencesMapper.deleteByPrimaryKey(audienceId_: Long) =
    delete {
        where(audienceId, isEqualTo(audienceId_))
    }

fun AudiencesMapper.insert(record: AudiencesRecord) =
    insert(this::insert, record, Audiences) {
        map(audienceId).toProperty("audienceId")
        map(surveyId).toProperty("surveyId")
        map(nickname).toProperty("nickname")
        map(email).toProperty("email")
        map(createdAt).toProperty("createdAt")
    }

fun AudiencesMapper.insertMultiple(records: Collection<AudiencesRecord>) =
    insertMultiple(this::insertMultiple, records, Audiences) {
        map(audienceId).toProperty("audienceId")
        map(surveyId).toProperty("surveyId")
        map(nickname).toProperty("nickname")
        map(email).toProperty("email")
        map(createdAt).toProperty("createdAt")
    }

fun AudiencesMapper.insertMultiple(vararg records: AudiencesRecord) =
    insertMultiple(records.toList())

fun AudiencesMapper.insertSelective(record: AudiencesRecord) =
    insert(this::insert, record, Audiences) {
        map(audienceId).toPropertyWhenPresent("audienceId", record::audienceId)
        map(surveyId).toPropertyWhenPresent("surveyId", record::surveyId)
        map(nickname).toPropertyWhenPresent("nickname", record::nickname)
        map(email).toPropertyWhenPresent("email", record::email)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
    }

private val columnList = listOf(audienceId, surveyId, nickname, email, createdAt)

fun AudiencesMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Audiences, completer)

fun AudiencesMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Audiences, completer)

fun AudiencesMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Audiences, completer)

fun AudiencesMapper.selectByPrimaryKey(audienceId_: Long) =
    selectOne {
        where(audienceId, isEqualTo(audienceId_))
    }

fun AudiencesMapper.update(completer: UpdateCompleter) =
    update(this::update, Audiences, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: AudiencesRecord) =
    apply {
        set(audienceId).equalTo(record::audienceId)
        set(surveyId).equalTo(record::surveyId)
        set(nickname).equalTo(record::nickname)
        set(email).equalTo(record::email)
        set(createdAt).equalTo(record::createdAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: AudiencesRecord) =
    apply {
        set(audienceId).equalToWhenPresent(record::audienceId)
        set(surveyId).equalToWhenPresent(record::surveyId)
        set(nickname).equalToWhenPresent(record::nickname)
        set(email).equalToWhenPresent(record::email)
        set(createdAt).equalToWhenPresent(record::createdAt)
    }

fun AudiencesMapper.updateByPrimaryKey(record: AudiencesRecord) =
    update {
        set(surveyId).equalTo(record::surveyId)
        set(nickname).equalTo(record::nickname)
        set(email).equalTo(record::email)
        set(createdAt).equalTo(record::createdAt)
        where(audienceId, isEqualTo(record::audienceId))
    }

fun AudiencesMapper.updateByPrimaryKeySelective(record: AudiencesRecord) =
    update {
        set(surveyId).equalToWhenPresent(record::surveyId)
        set(nickname).equalToWhenPresent(record::nickname)
        set(email).equalToWhenPresent(record::email)
        set(createdAt).equalToWhenPresent(record::createdAt)
        where(audienceId, isEqualTo(record::audienceId))
    }