import axios from 'axios'
import errorParser from '@/utils/error-parser'

export default {
  /**
   * Create answer
   */
  create (surveyId, username, email, options) {
    return new Promise((resolve, reject) => {
      axios.post(`/open/answers`, {
        surveyId: surveyId,
        username: username,
        email: email,
        options: options
      }).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(errorParser.parse(error))
      })
    })
  }
}
