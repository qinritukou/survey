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
            </div>
          </div>
          <hr/>
          <div class="row">
            <label>Answer List</label>
          </div>
          <div class="row" v-for="option in question.options" v-bind:key="option.optionId">
            <div class="col-md-12">
              <label class="label text-info">{{ option.title }}</label>
            </div>
          </div>
        </div>
      </div>
    </div>
    <CreateUpdateQuestionModal
      :question="selectedQuestion"/>

  </div>
</template>

<script>
import $ from 'jquery'
import surveyService from '@/services/surveies'
import questionService from '@/services/questions'
import CreateUpdateQuestionModal from '@/modals/CreateUpdateQuestionModal.vue'

export default {
  name: 'SurveyPage',
  data() {
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
    }
  }
}
</script>

<style lang="scss" scoped>
.operator button {
  margin-left: 10px;
}
</style>
