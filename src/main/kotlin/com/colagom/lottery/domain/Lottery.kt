package com.colagom.lottery.domain

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Lottery(
    @Id
    var drwNo: Int = 0,
    var bnusNo: Int = 0,
    var drwNoDate: String = "",
    var drwtNo1: Int = 0,
    var drwtNo2: Int = 0,
    var drwtNo3: Int = 0,
    var drwtNo4: Int = 0,
    var drwtNo5: Int = 0,
    var drwtNo6: Int = 0,
    var firstAccumamnt: Int = 0,
    var firstPrzwnerCo: Int = 0,
    var firstWinamnt: Long = 0L,
    var returnValue: String = "",
    var totSellamnt: Long = 0L
) {
    @CreatedDate
    @Column(insertable = false, updatable = false)
    val createdAt = LocalDateTime.now()
}