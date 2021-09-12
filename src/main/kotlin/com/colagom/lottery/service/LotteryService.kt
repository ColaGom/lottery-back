package com.colagom.lottery.service

import com.colagom.lottery.core.toggleModel
import com.colagom.lottery.domain.LotteryRepository
import com.colagom.lottery.dto.LotteryDto
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LotteryService(
    private val repository: LotteryRepository
) {
    @Transactional
    fun findAll(
        page: Int = 1
    ) = repository.findAll(PageRequest.of(page - 1, 100))

    @Transactional
    fun save(dto: LotteryDto): LotteryDto = repository.save(dto.toggleModel()).let(LotteryDto::of)

    @Transactional
    fun update(dto: LotteryDto): Int {
        val lottery = repository.findById(dto.drwNo).orElseThrow {
            IllegalArgumentException("${dto.drwNo} not exist")
        }

        with(lottery) {
            bnusNo = dto.bnusNo
            drwNoDate = dto.drwNoDate
            drwtNo1 = dto.drwtNo1
            drwtNo2 = dto.drwtNo2
            drwtNo3 = dto.drwtNo3
            drwtNo4 = dto.drwtNo4
            drwtNo5 = dto.drwtNo5
            drwtNo6 = dto.drwtNo6
            firstAccumamnt = dto.firstAccumamnt
            firstPrzwnerCo = dto.firstPrzwnerCo
            firstWinamnt = dto.firstWinamnt
            totSellamnt = dto.totSellamnt
        }

        return lottery.drwNo
    }

    @Transactional
    fun findById(id: Int) = repository.findById(id).orElseThrow {
        IllegalArgumentException("$id not exist")
    }.let(LotteryDto::of)
}