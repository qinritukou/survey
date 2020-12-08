package com.orangeman.example.survey.domain.model.survey

class SurveyNotExistException: Exception("Survey does not exist or you don't have the permission.") {
}