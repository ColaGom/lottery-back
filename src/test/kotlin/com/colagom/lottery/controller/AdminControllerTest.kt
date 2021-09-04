package com.colagom.lottery.controller

import com.colagom.lottery.domain.LotteryRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class AdminControllerTest {
    @LocalServerPort
    var port: Int = 0

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    lateinit var lotteryRepository: LotteryRepository

    @BeforeEach
    fun tearDown() {
        lotteryRepository.deleteAll()
    }

    @Test
    fun `extract single`() {
        val url = "http://localhost:$port/admin/extract"
        val target = intArrayOf(1)

        val response = restTemplate.postForEntity(url, target, IntArray::class.java)

        assertAll(
            { assertTrue(response.statusCode.is2xxSuccessful) },
            { assertEquals(response.body?.get(0), 1) }
        )
    }
}