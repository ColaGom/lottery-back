package com.colagom.lottery.controller.api

import com.colagom.lottery.domain.LotteryRepository
import com.colagom.lottery.dto.LotteryDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class LotteryApiControllerTest {

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
    fun `post lottery is ok`() {
        val dto = LotteryDto(
            drwNo = 1
        )

        val url = "http://localhost:$port/api/lottery"

        val response = restTemplate.postForEntity(url, dto, Int::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)

        val first = lotteryRepository.findAll().first()
        assertThat(first.drwNo).isEqualTo(dto.drwNo)
    }
}