package com.colagom.lottery.contoller.api

import com.colagom.lottery.dto.LotteryDto
import com.colagom.lottery.service.LotteryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/lottery")
class LotteryApiController(
    private val lotteryService: LotteryService
) {
    @GetMapping
    fun get() = lotteryService.findAll()

    @PostMapping
    fun post(
        @RequestBody requestDto: LotteryDto
    ): LotteryDto = lotteryService.save(requestDto)

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Int): LotteryDto = lotteryService.findById(id)
}