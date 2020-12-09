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
  }
}