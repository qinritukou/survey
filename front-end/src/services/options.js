import axios from 'axios'
import errorParser from '@/utils/error-parser'

export default {
  /**
   * Get options
   */
  getOptions (surveyId, questionId) {
    return new Promise((resolve, reject) => {
      axios.get(`/surveies/${surveyId}/questions/${questionId}/options`).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Create option
   */
  create (surveyId, questionId, option) {
    return new Promise((resolve, reject) => {
      axios.post(`/surveies/${surveyId}/questions/${questionId}/options`, option).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Delete survey
   */
  delete (surveyId, questionId, optionId) {
    return new Promise((resolve, reject) => {
      axios.delete(`/surveies/${surveyId}/questions/${questionId}/options/${optionId}`).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  }
}
