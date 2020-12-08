package com.orangeman.example.survey.web.pages

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping(value = ["/", "/login", "/register"])
    fun entry(): String = "index"

}