import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '@/views/HomePage'
import LoginPage from '@/views/LoginPage'
import RegisterPage from '@/views/RegisterPage'
import SurveyPage from '@/views/SurveyPage'
import SurveyResultPage from '@/views/SurveyResultPage'
import OpenSurveyPage from '@/views/OpenSurveyPage'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
    path: '/',
    name: 'home',
    component: HomePage
  }, {
    path: '/login',
    name: 'login',
    component: LoginPage
  }, {
    path: '/register',
    name: 'register',
    component: RegisterPage
  }, {
    path: '/survey/:surveyId',
    name: 'survey',
    component: SurveyPage
  }, {
    path: '/survey/:surveyId/result',
    name: 'surveyResult',
    component: SurveyResultPage
  }, {
    path: '/open/survey/:surveyId',
    name: 'openSurvey',
    component: OpenSurveyPage
  }]
})
