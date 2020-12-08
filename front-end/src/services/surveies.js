import axios from 'axios'
import errorParser from '@/utils/error-parser'

export default {
  /**
   * Get surveies
   */
  getSurveies () {
    return new Promise((resolve, reject) => {
      axios.get('/surveies').then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Create survey
   */
  create (survey) {
    return new Promise((resolve, reject) => {
      axios.post('/surveies', survey).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Update survey
   */
  update (survey) {
    return new Promise((resolve, reject) => {
      axios.put(`/surveies/${survey.surveyId}`, survey).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  },
  /**
   * Delete survey
   */
  delete (surveyId) {
    return new Promise((resolve, reject) => {
      axios.delete(`/surveies/${surveyId}`).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  }
}
