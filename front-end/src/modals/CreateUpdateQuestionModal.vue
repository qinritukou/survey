<template>
  <form @submit.prevent="saveQuestion">
    <div class="modal" tabindex="-1" role="dialog" backdrop="static" id="createUpdateQuestionModal">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">{{ question.questionId > 0 ? 'Update' : 'Create' }} Question</h5>
            <button type="button" class="close" @click="close" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div v-show="errorMessage" class="alert alert-danger failed">{{ errorMessage }}</div>
            <div class="form-group">
              <input type="text" class="form-control" id="questionTitleInput" v-model="question.title" placeholder="Question title" maxlength="128">
              <div class="field-error" v-if="$v.question.title.$dirty">
                <div class="error" v-if="!$v.question.title.required">Title is required</div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default btn-cancel" @click="close">Cancel</button>
            <button type="submit" class="btn btn-primary">
              {{ question.questionId > 0 ? 'Update' : 'Create' }}
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
import questionService from '@/services/questions'

export default {
  name: 'CreateUpdateQuestionModal',
  props: ['question'],
  data () {
    return {
      errorMessage: ''
    }
  },
  mounted () {
    $('#createUpdateQuestionModal').on('shown.bs.modal', () => {
      $('#questionTitleInput').trigger('focus')
    })
  },
  validations: {
    question: {
      title: {
        required
      }
    }
  },
  methods: {
    saveQuestion () {
      this.$v.$touch()
      if (this.$v.$invalid) {
        return
      }

      if (this.question.questionId > 0) {
        questionService.update(this.question).then((updatedQuestion) => {
          this.close()
        }).catch((err) => {
          this.errorMessage = err.message
        })
      } else {
        questionService.create(this.question).then((createdQuestion) => {
          this.close()
        }).catch((err) => {
          this.errorMessage = err.message
        })
      }
    },
    close () {
      this.$v.$reset()
      this.question.title = ''
      this.errorMessage = ''
      $('#createUpdateQuestionModal').modal('hide')
      this.$parent.loadQuestions()
    }
  }
}
</script>
