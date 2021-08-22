package com.colagom.lottery.domain

import org.springframework.data.jpa.repository.JpaRepository

interface LotteryRepository : JpaRepository<Lottery, Int>