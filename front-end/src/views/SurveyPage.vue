<template>
  <div class="container">
    <div><h1 class="page-title"><code>{{ survey.title }}</code>'s Question List</h1></div>
    <hr/>
    <div class="row">
      <button class="btn btn-primary" @click="createQuestion()">
        <font-awesome-icon icon="plus" />
        Create New Question
      </button>
    </div>
    <div class="row" style="margin-top: 10px;" v-for="question in questions" v-bind:key="question.questionId">
      <div class="card col-md-12">
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">{{ question.title }}</h5>
            </div>
            <div class="col-md-6 text-right operator">
              <button class="btn btn-danger" @click="deleteQuestion(question)">
                Delete
              </button>
              <button class="btn btn-info" @click="openQuestion(question)">
                Edit
              </button>
              <button class="btn btn-primary" @click="addOption(question)">
                Add Answer Option
              </button>
            </div>
          </div>
          <hr/>
          <div class="row">
            <h6>Answer List</h6>
          </div>
          <div class="row" v-for="option in question.options" v-bind:key="option.optionId">
            <div class="col-md-12" style="border: 1px solid #eee; border-radius: 6px; margin-bottom: 5px;">
              <label class="text-info" style="padding-top: 5px;">{{ option.title }}</label>
              <button class="btn" @click="deleteOption(question, option)" style="float: right">X</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <CreateUpdateQuestionModal
      :question="selectedQuestion"/>
    <CreateOptionModal
      :question="selectedQuestion"/>

  </div>
</template>

<script>
import $ from 'jquery'
import surveyService from '@/services/surveies'
import questionService from '@/services/questions'
import optionService from '@/services/options'
import CreateUpdateQuestionModal from '@/modals/CreateUpdateQuestionModal.vue'
import CreateOptionModal from '@/modals/CreateOptionModal.vue'

export default {
  name: 'SurveyPage',
  data () {
    return {
      selectedQuestion: {},
      survey: {},
      questions: []
    }
  },
  mounted () {
    this.loadSurvey()
    this.loadQuestions()
  },
  components: {
    CreateUpdateQuestionModal,
    CreateOptionModal
  },
  methods: {
    loadSurvey () {
      surveyService.getSurvey(this.$route.params.surveyId).then(data => {
        this.survey = data
      })
    },
    loadQuestions () {
      questionService.getQuestions(this.$route.params.surveyId).then(data => {
        this.questions = data
      })
    },
    createQuestion () {
      this.selectedQuestion = {
        surveyId: this.$route.params.surveyId,
        questionId: 0,
        title: ''
      }
      $('#createUpdateQuestionModal').modal('show')
    },
    openQuestion (question) {
      this.selectedQuestion = {
        surveyId: this.$route.params.surveyId,
        questionId: question.questionId,
        title: question.title
      }
      $('#createUpdateQuestionModal').modal('show')
    },
    deleteQuestion (question) {
      if (question.options.length > 0) {
        alert('This question has answer options. You should delete the options first.')
        return
      }
      questionService.delete(question.surveyId, question.questionId).then(data => {
        this.loadQuestions()
      })
    },
    addOption (question) {
      this.selectedQuestion = question
      $('#createOptionModal').modal('show')
    },
    deleteOption (question, option) {
      optionService.delete(question.surveyId, question.questionId, option.optionId).then(data => {
        this.loadQuestions()
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.operator button {
  margin-left: 10px;
}
</style>
