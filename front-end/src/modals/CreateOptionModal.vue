<template>
  <form @submit.prevent="saveOption">
    <div class="modal" tabindex="-1" role="dialog" backdrop="static" id="createOptionModal">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Create Answer Option</h5>
            <button type="button" class="close" @click="close" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div v-show="errorMessage" class="alert alert-danger failed">{{ errorMessage }}</div>
            <div class="form-group">
              <input type="text" class="form-control" id="questionTitleInput" v-model="option.title" placeholder="Answer option title" maxlength="128">
              <div class="field-error" v-if="$v.option.title.$dirty">
                <div class="error" v-if="!$v.option.title.required">Title is required</div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default btn-cancel" @click="close">Cancel</button>
            <button type="submit" class="btn btn-primary">Create</button>
          </div>
        </div>
      </div>
    </div>
  </form>
</template>

<script>
import $ from 'jquery'
import { required } from 'vuelidate/lib/validators'
import optionService from '@/services/options'

export default {
  name: 'CreateUpdateQuestionModal',
  props: ['question'],
  data () {
    return {
      errorMessage: '',
      option: {
        questionId: this.question.questionId
      }
    }
  },
  mounted () {
    $('#createOptionModal').on('shown.bs.modal', () => {
      $('#optionTitleInput').trigger('focus')
    })
  },
  validations: {
    option: {
      title: {
        required
      }
    }
  },
  methods: {
    saveOption () {
      this.$v.$touch()
      if (this.$v.$invalid) {
        return
      }
      this.option.questionId = this.question.questionId
      optionService.create(this.question.surveyId, this.question.questionId, this.option).then((createdOption) => {
        this.close()
      }).catch((err) => {
        this.errorMessage = err.message
      })
    },
    close () {
      this.$v.$reset()
      this.question.title = ''
      this.errorMessage = ''
      $('#createOptionModal').modal('hide')
      this.$parent.loadQuestions()
    }
  }
}
</script>
