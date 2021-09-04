package com.colagom.lottery.contoller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("extract")
@Controller
class ExtractController {

    @GetMapping
    fun index() = "extract"
}