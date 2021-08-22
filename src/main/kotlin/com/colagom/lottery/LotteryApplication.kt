package com.colagom.lottery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class LotteryApplication

fun main(args: Array<String>) {
    runApplication<LotteryApplication>(*args)
}