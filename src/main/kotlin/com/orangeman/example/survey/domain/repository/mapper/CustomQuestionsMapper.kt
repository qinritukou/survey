package com.orangeman.example.survey.domain.repository.mapper

import com.orangeman.example.survey.automake.domain.QuestionsRecord
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options

@Mapper
interface CustomQuestionsMapper {

    @Insert("""
        INSERT INTO questions(title, survey_id, created_by)
        VALUES(#{title}, #{survey_id}, #{creatd_by})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "question_id")
    fun insert(questionsRecord: QuestionsRecord)

}