<template>
  <div class="container">
    <div><h1 class="page-title"><code>{{ survey.title }}</code>'s Result</h1></div>
    <hr/>
    <div class="row" style="margin-top: 10px;" v-for="surveyResult in surveyResults" v-bind:key="surveyResult.questionId">
      <div class="card col-md-12">
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <h5 class="card-title">{{ surveyResult.title }}</h5>
            </div>
          </div>
          <hr/>
          <div class="row">
            <h6>Answer List</h6>
          </div>
          <div class="row" v-for="optionResult in surveyResult.optionResults" v-bind:key="optionResult.optionId">
            <div class="col-md-2">
              <label class="text-info">{{ optionResult.title }}: </label>
              <label class="option-count">{{ optionResult.count }}</label>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import $ from 'jquery'
import surveyService from '@/services/surveies'

export default {
  name: 'SurveyPage',
  data () {
    return {
      survey: {},
      surveyResults: []
    }
  },
  mounted () {
    this.loadSurvey()
    this.loadSurveyResults()
  },
  components: {
  },
  methods: {
    loadSurvey () {
      surveyService.getSurvey(this.$route.params.surveyId).then(data => {
        this.survey = data
      })
    },
    loadSurveyResults () {
      surveyService.getSurveyResult(this.$route.params.surveyId).then(data => {
        this.surveyResults = data
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

<style scoped>
.option-count {
  background-color:orange;
  border: 1px solid orange;
  border-radius: 6px;
  padding: 0 5px;
  margin-left: 10px;
}
</style>