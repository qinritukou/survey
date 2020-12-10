import axios from 'axios'
import errorParser from '@/utils/error-parser'

export default {
  /**
   * Get questions
   */
  getQuestions (surveyId) {
    return new Promise((resolve, reject) => {
      axios.get(`/surveies/${surveyId}/questions`).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Get open questions
   */
  getOpenQuestions (surveyId) {
    return new Promise((resolve, reject) => {
      axios.get(`/open/surveies/${surveyId}/questions`).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Create question
   */
  create (question) {
    return new Promise((resolve, reject) => {
      axios.post(`/surveies/${question.surveyId}/questions`, question).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Update question
   */
  update (question) {
    return new Promise((resolve, reject) => {
      axios.put(`/surveies/${question.surveyId}/questions/${question.questionId}`, question).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Delete survey
   */
  delete (surveyId, questionId) {
    return new Promise((resolve, reject) => {
      axios.delete(`/surveies/${surveyId}/questions/${questionId}`).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  }
}
