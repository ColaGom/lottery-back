package com.colagom.lottery.contoller.api

import com.colagom.lottery.dto.LotteryDto
import com.colagom.lottery.service.LotteryService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import javax.validation.constraints.Size

@RestController
@RequestMapping("api/lottery")
@Validated
class LotteryApiController(
    private val lotteryService: LotteryService,
    private val restTemplate: RestTemplate
) {
    @GetMapping
    fun get(
        @RequestParam page: Int,
    ) = lotteryService.findAll(page)

    @PostMapping
    fun post(
        @RequestBody requestDto: LotteryDto
    ): LotteryDto = lotteryService.save(requestDto)

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Int): LotteryDto = lotteryService.findById(id)

    @PostMapping("extract")
    fun extract(
        @Size(min = 1, max = 100, message = "size 1 to 100")
        @RequestBody drwNums: IntArray,
        bindingResult: BindingResult,
    ) = if (bindingResult.hasErrors()) {
        val msg = bindingResult.allErrors
            .map { it as FieldError }
            .joinToString(transform = { "${it.field} -> ${it.defaultMessage}" })

        ResponseEntity.badRequest().body(msg)
    } else {
        val saved = mutableListOf<Int>()
        drwNums.forEach { drwNo ->
            val url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=$drwNo"
            restTemplate.getForEntity(url, LotteryDto::class.java)
                .body?.let {
                    saved.add(drwNo)
                    lotteryService.save(it)
                }

            Thread.sleep(200)
        }

        ResponseEntity.ok(saved)
    }
}