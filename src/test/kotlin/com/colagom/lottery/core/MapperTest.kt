package com.colagom.lottery.core

import com.colagom.lottery.domain.Lottery
import com.colagom.lottery.dto.LotteryDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MapperTest {

    @Test
    fun `toggle entity to dto`() {
        val entity = Lottery()

        val dto = entity.toggleModel<LotteryDto>()

        assertThat(entity.drwNo).isEqualTo(dto.drwNo)
    }

    @Test
    fun `toggle dto to entity`() {
        val dto = LotteryDto()

        val entity = dto.toggleModel<Lottery>()

        assertThat(dto.drwNo).isEqualTo(entity.drwNo)
    }
}