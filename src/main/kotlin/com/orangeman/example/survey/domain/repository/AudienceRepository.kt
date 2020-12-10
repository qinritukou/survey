package com.orangeman.example.survey.domain.repository

import com.orangeman.example.survey.automake.domain.AudiencesRecord
import com.orangeman.example.survey.automake.mapper.AudiencesDynamicSqlSupport
import com.orangeman.example.survey.automake.mapper.AudiencesMapper
import com.orangeman.example.survey.automake.mapper.insertSelective
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.springframework.stereotype.Repository

@Repository
class AudienceRepository(
    private val audiencesMapper: AudiencesMapper
) {

    fun create(audiencesRecord: AudiencesRecord): Int {
        return audiencesMapper.insertSelective(audiencesRecord)
    }

    fun findByEmailAndSurveyId(email: String, surveyId: Long) =
        selectList(
            audiencesMapper::selectMany,
            listOf(
                AudiencesDynamicSqlSupport.Audiences.audienceId,
                AudiencesDynamicSqlSupport.Audiences.surveyId,
                AudiencesDynamicSqlSupport.Audiences.nickname,
                AudiencesDynamicSqlSupport.Audiences.email
            ),
            AudiencesDynamicSqlSupport.Audiences
        ) {
            where(AudiencesDynamicSqlSupport.Audiences.email, SqlBuilder.isEqualTo(email))
            and(AudiencesDynamicSqlSupport.Audiences.surveyId, SqlBuilder.isEqualTo(surveyId))
        }.firstOrNull()

}