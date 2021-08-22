package com.colagom.lottery.domain

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Lottery(
    @Id
    val drwNo: Int,
    val bnusNo: Int,
    val drwNoDate: String,
    val drwtNo1: Int,
    val drwtNo2: Int,
    val drwtNo3: Int,
    val drwtNo4: Int,
    val drwtNo5: Int,
    val drwtNo6: Int,
    val firstAccumamnt: Int,
    val firstPrzwnerCo: Int,
    val firstWinamnt: Long,
    val returnValue: String,
    val totSellamnt: Long,
    @CreatedDate
    val createdAt: LocalDateTime? = null
)