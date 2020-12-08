<template>
  <form @submit.prevent="saveSurvey">
    <div class="modal" tabindex="-1" role="dialog" backdrop="static" id="createUpdateSurveyModal">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">{{ survey.surveyId > 0 ? 'Update' : 'Create' }} Survey</h5>
            <button type="button" class="close" @click="close" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div v-show="errorMessage" class="alert alert-danger failed">{{ errorMessage }}</div>
            <div class="form-group">
              <input type="text" class="form-control" id="surveyTitleInput" v-model="survey.title" placeholder="Survey title" maxlength="128">
              <div class="field-error" v-if="$v.survey.title.$dirty">
                <div class="error" v-if="!$v.survey.title.required">Title is required</div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default btn-cancel" @click="close">Cancel</button>
            <button type="submit" class="btn btn-primary">
              {{ survey.surveyId > 0 ? 'Update' : 'Create' }}
            </button>
          </div>
        </div>
      </div>
    </div>
  </form>
</template>

<script>
import $ from 'jquery'
import { required } from 'vuelidate/lib/validators'
import surveyService from '@/services/surveies'

export default {
  name: 'CreateUpdateSurveyModal',
  props: ['survey'],
  data () {
    return {
      errorMessage: ''
    }
  },
  mounted () {
    $('#createUpdateSurveyModal').on('shown.bs.modal', () => {
      $('#surveyTitleInput').trigger('focus')
    })
  },
  validations: {
    survey: {
      title: {
        required
      }
    }
  },
  methods: {
    saveSurvey () {
      this.$v.$touch()
      if (this.$v.$invalid) {
        return
      }

      if (this.survey.surveyId > 0) {
        surveyService.update(this.survey).then((createdSurvey) => {
          this.close()
        }).catch((err) => {
          this.errorMessage = err.message
        })
      } else {
        surveyService.create(this.survey).then((createdSurvey) => {
          this.close()
        }).catch((err) => {
          this.errorMessage = err.message
        })
      }
    },
    close () {
      this.$v.$reset()
      this.survey.title = ''
      this.errorMessage = ''
      $('#createUpdateSurveyModal').modal('hide')
      this.$parent.loadSurveies()
    }
  }
}
</script>
