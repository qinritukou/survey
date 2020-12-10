<template>
  <div class="container">
    <div><h1 class="page-title">My Survey List</h1></div>
    <div class="row">
      <button class="btn btn-primary" @click="createSurvey()">
        <font-awesome-icon icon="plus" />
        Create New Survery
      </button>
    </div>
    <div class="row" style="margin-top: 10px;" v-for="survey in surveies" v-bind:key="survey.surveyId">
      <div class="card col-md-12">
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">{{ survey.title }}</h5>
            </div>
            <div class="col-md-6 text-right operator">
              <button class="btn btn-danger" @click="deleteSurvey(survey)">
                Delete
              </button>
              <button class="btn btn-info" @click="openSurvey(survey)">
                Edit
              </button>
              <button class="btn btn-primary" @click="gotoQuestionPage(survey)">
                Add Questions
              </button>
              <button class="btn btn-primary" @click="gotoResultPage(survey)">
                See Results
              </button>

            </div>
          </div>
        </div>
      </div>
    </div>
    <CreateUpdateSurveyModal
      :survey="selectedSurvey"/>
  </div>
</template>

<script>
import $ from 'jquery'
import surveyService from '@/services/surveies'
import CreateUpdateSurveyModal from '@/modals/CreateUpdateSurveyModal.vue'

export default {
  name: 'HomePage',
  data () {
    return {
      selectedSurvey: {},
      surveies: []
    }
  },
  mounted () {
    this.loadSurveies()
  },
  components: {
    CreateUpdateSurveyModal
  },
  methods: {
    loadSurveies () {
      surveyService.getSurveies().then(data => {
        this.surveies = data
      })
    },
    createSurvey () {
      this.selectedSurvey = {}
      $('#createUpdateSurveyModal').modal('show')
    },
    openSurvey (survey) {
      this.selectedSurvey = {
        surveyId: survey.surveyId,
        title: survey.title
      }
      $('#createUpdateSurveyModal').modal('show')
    },
    deleteSurvey(survey) {
      surveyService.delete(survey.surveyId).then(data => {
        this.loadSurveies()
      })
    },
    gotoQuestionPage (survey) {
      this.$router.push({name: 'survey', params: {surveyId: survey.surveyId}})
    },
    gotoResultPage(survey) {
      this.$router.push({name: 'surveyResult', params: {surveyId: survey.surveyId}})
    }
  }
}
</script>

<style scoped>
.operator button {
  margin-left: 10px;
}
</style>
