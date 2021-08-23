package com.colagom.lottery.contoller

import com.colagom.lottery.dto.LotteryDto
import com.colagom.lottery.service.LotteryService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.client.RestTemplate

@RequestMapping("admin")
@Controller
class AdminController(
    private val restTemplate: RestTemplate,
    private val lotteryService: LotteryService
) {

    @GetMapping
    fun index() = "admin"

    @PostMapping("extract")
    fun extract(
        @RequestBody drwNums: IntArray
    ): IntArray {
        val saved = mutableListOf<Int>()
        drwNums.forEach { drwNo ->
            val url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=$drwNo"
            restTemplate.getForEntity(url, LotteryDto::class.java)
                .body?.let {
                    saved.add(drwNo)
                    lotteryService.save(it)
                }
        }

        return saved.toIntArray()
    }
}