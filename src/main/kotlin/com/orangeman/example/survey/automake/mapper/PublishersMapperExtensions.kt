/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2020-12-03T23:37:53.639+09:00
 */
package com.orangeman.example.survey.automake.mapper

import com.orangeman.example.survey.automake.domain.PublishersRecord
import com.orangeman.example.survey.automake.mapper.PublishersDynamicSqlSupport.Publishers
import com.orangeman.example.survey.automake.mapper.PublishersDynamicSqlSupport.Publishers.createdAt
import com.orangeman.example.survey.automake.mapper.PublishersDynamicSqlSupport.Publishers.email
import com.orangeman.example.survey.automake.mapper.PublishersDynamicSqlSupport.Publishers.password
import com.orangeman.example.survey.automake.mapper.PublishersDynamicSqlSupport.Publishers.publisherId
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun PublishersMapper.count(completer: CountCompleter) =
    countFrom(this::count, Publishers, completer)

fun PublishersMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Publishers, completer)

fun PublishersMapper.deleteByPrimaryKey(publisherId_: Long) =
    delete {
        where(publisherId, isEqualTo(publisherId_))
    }

fun PublishersMapper.insert(record: PublishersRecord) =
    insert(this::insert, record, Publishers) {
        map(publisherId).toProperty("publisherId")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(createdAt).toProperty("createdAt")
    }

fun PublishersMapper.insertMultiple(records: Collection<PublishersRecord>) =
    insertMultiple(this::insertMultiple, records, Publishers) {
        map(publisherId).toProperty("publisherId")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(createdAt).toProperty("createdAt")
    }

fun PublishersMapper.insertMultiple(vararg records: PublishersRecord) =
    insertMultiple(records.toList())

fun PublishersMapper.insertSelective(record: PublishersRecord) =
    insert(this::insert, record, Publishers) {
        map(publisherId).toPropertyWhenPresent("publisherId", record::publisherId)
        map(email).toPropertyWhenPresent("email", record::email)
        map(password).toPropertyWhenPresent("password", record::password)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
    }

private val columnList = listOf(publisherId, email, password, createdAt)

fun PublishersMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Publishers, completer)

fun PublishersMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Publishers, completer)

fun PublishersMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Publishers, completer)

fun PublishersMapper.selectByPrimaryKey(publisherId_: Long) =
    selectOne {
        where(publisherId, isEqualTo(publisherId_))
    }

fun PublishersMapper.update(completer: UpdateCompleter) =
    update(this::update, Publishers, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: PublishersRecord) =
    apply {
        set(publisherId).equalTo(record::publisherId)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(createdAt).equalTo(record::createdAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: PublishersRecord) =
    apply {
        set(publisherId).equalToWhenPresent(record::publisherId)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(createdAt).equalToWhenPresent(record::createdAt)
    }

fun PublishersMapper.updateByPrimaryKey(record: PublishersRecord) =
    update {
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(createdAt).equalTo(record::createdAt)
        where(publisherId, isEqualTo(record::publisherId))
    }

fun PublishersMapper.updateByPrimaryKeySelective(record: PublishersRecord) =
    update {
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(createdAt).equalToWhenPresent(record::createdAt)
        where(publisherId, isEqualTo(record::publisherId))
    }