package com.colagom.lottery.domain

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
    var firstAccumamnt: Long = 0,
    var firstPrzwnerCo: Long = 0,
    var firstWinamnt: Long = 0L,
    var totSellamnt: Long = 0L
) : BaseTimeEntity()