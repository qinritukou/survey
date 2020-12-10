<template>
  <div class="container" style="margin-top: 20px;">
    <div><h1 class="page-title text-center"><code>{{ survey.title }}</code></h1></div>
    <div class="text-center">Thank you for you cooperation.</div>
    <div class="row" style="margin-top: 10px;" v-for="(question, index) in questions" v-bind:key="question.questionId">
      <div class="card col-md-12">
        <div class="card-body">
          <div class="row">
            <h5 class="card-title">【Q {{index+1}}】{{ question.title }}</h5>
          </div>
          <div class="row" v-for="(option, optIdx) in question.options" v-bind:key="option.optionId">
            <button class="btn option-button text-left btn-outline-primary" v-show="option.selected === true"
              @click="selectOption(question, option)">
                {{ optIdx+1 }}. {{ option.title }} ✔️
            </button>
            <button class="btn option-button text-left btn-outline-info" v-show="!option.selected"
              @click="selectOption(question, option)">
                {{ optIdx+1 }}. {{ option.title }}
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="row" style="margin-top: 20px;">
      <div class="col-md-6">
        <input type="text" class="form-control" v-model="username" placeholder="Input your name" required/>
      </div>
      <div class="col-md-6">
        <input type="email" class="form-control" v-model="email" placeholder="Input your email" required/>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12 text-center" @click="submitAnswer()">
        <button class="btn btn-primary submit-button">
          Confirm The Answer
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import surveyService from '@/services/surveies'
import questionService from '@/services/questions'
import answerService from '@/services/answers'

export default {
  name: 'OpenSurveyPage',
  data () {
    return {
      renderComponent: true,
      selectedQuestion: {},
      survey: {},
      questions: [],
      username: '',
      email: ''
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
      surveyService.getOpenSurvey(this.$route.params.surveyId).then(data => {
        this.survey = data
      })
    },
    loadQuestions () {
      questionService.getOpenQuestions(this.$route.params.surveyId).then(data => {
        this.questions = data
      })
    },
    selectOption (question, option) {
      var options = question.options
      for (var i = 0; i < options.length; ++i) {
        options[i].selected = false
      }
      option.selected = true
      this.$forceUpdate()
    },
    submitAnswer () {
      if (this.username === '') {
        alert('Please input your name')
        return
      }
      if (this.email === '') {
        alert('Please input your email')
        return
      }
      var options = []
      for (var i = 0; i < this.questions.length; ++i) {
        var hasAnswer = false
        for (var j = 0; j < this.questions[i].options.length; ++j) {
          if (this.questions[i].options[j].selected === true) {
            hasAnswer = true
            this.questions[i].options[j].questionId = this.questions[i].questionId
            options.push(this.questions[i].options[j])
          }
        }
        if (hasAnswer === false) {
          alert(`You should answer question ${this.questions[i].title}`)
          return
        }
      }
      answerService.create(this.questions[0].surveyId, this.username, this.email, options).then(data => {
        alert('Thank you for your answer')
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.option-button {
  margin-top: 5px;
  width: 100%;
}
.submit-button {
  margin-top: 20px;
}
</style>
