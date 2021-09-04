package com.colagom.lottery.contoller

import com.colagom.lottery.service.LotteryService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("admin")
@Controller
class AdminController(
    val lotteryService: LotteryService
) {

    @GetMapping
    fun index(model: Model): String {
        model.addAttribute(
            "lotteries",
            lotteryService.findAll()
        )

        return "admin"
    }
}