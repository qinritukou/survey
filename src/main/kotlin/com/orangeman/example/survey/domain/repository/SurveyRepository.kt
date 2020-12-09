package com.orangeman.example.survey.domain.repository

import com.orangeman.example.survey.automake.domain.SurveiesRecord
import com.orangeman.example.survey.automake.mapper.*
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.springframework.stereotype.Repository

@Repository
class SurveyRepository(
    private val surveiesMapper: SurveiesMapper
) {

    fun create(surveiesRecord: SurveiesRecord): Int {
        return surveiesMapper.insertSelective(surveiesRecord)
    }

    fun update(surveiesRecord: SurveiesRecord): Int {
        return surveiesMapper.updateByPrimaryKeySelective(surveiesRecord)
    }

    fun del(surveyId: Long): Int {
        return surveiesMapper.deleteByPrimaryKey(surveyId)
    }

    fun findByCreatedBy(createdBy: Long): List<SurveiesRecord> = selectList(
        surveiesMapper::selectMany,
        listOf(
            SurveiesDynamicSqlSupport.Surveies.surveyId,
            SurveiesDynamicSqlSupport.Surveies.title,
            SurveiesDynamicSqlSupport.Surveies.createdBy,
        ),
        SurveiesDynamicSqlSupport.Surveies
    ) {
        where(SurveiesDynamicSqlSupport.Surveies.createdBy, SqlBuilder.isEqualTo(createdBy))
    }

    fun findBySurveyIdAndCreatedBy(surveyId: Long, createdBy: Long): SurveiesRecord? = selectList(
        surveiesMapper::selectMany,
        listOf(
            SurveiesDynamicSqlSupport.Surveies.surveyId,
            SurveiesDynamicSqlSupport.Surveies.title,
            SurveiesDynamicSqlSupport.Surveies.createdBy,
        ),
        SurveiesDynamicSqlSupport.Surveies
    ) {
        where(SurveiesDynamicSqlSupport.Surveies.surveyId, SqlBuilder.isEqualTo(surveyId))
        and(SurveiesDynamicSqlSupport.Surveies.createdBy, SqlBuilder.isEqualTo(createdBy))
    }.firstOrNull()

    fun findBySurveyId(surveyId: Long): SurveiesRecord? = selectList(
            surveiesMapper::selectMany,
            listOf(
                    SurveiesDynamicSqlSupport.Surveies.surveyId,
                    SurveiesDynamicSqlSupport.Surveies.title,
                    SurveiesDynamicSqlSupport.Surveies.createdBy,
            ),
            SurveiesDynamicSqlSupport.Surveies
    ) {
        where(SurveiesDynamicSqlSupport.Surveies.surveyId, SqlBuilder.isEqualTo(surveyId))
    }.firstOrNull()

}