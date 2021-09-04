package com.colagom.lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.random.Random

@ExtendWith(SpringExtension::class)
@SpringBootTest
class LotteryRepositoryTest {
    private fun createDummy() = Lottery(
        Random.nextInt(),
        Random.nextInt(),
        "2020-01-01",
        Random.nextInt(),
        Random.nextInt(),
        Random.nextInt(),
        Random.nextInt(),
        Random.nextInt(),
        Random.nextInt(),
    )

    @Autowired
    lateinit var repository: LotteryRepository


    @BeforeEach
    fun `cleanup database`() {
        repository.deleteAll()
    }

    @Test
    fun `save and load`() {
        val dummy = createDummy()
        repository.save(dummy)
        val first = repository.findAll().first()

        assertThat(first.drwNo).isEqualTo(dummy.drwNo)
        assertThat(first.drwNoDate).isEqualTo(dummy.drwNoDate)
    }

    @Test
    fun `save and cleanup`() {
        val dummy = createDummy()
        repository.save(dummy)
        assertThat(repository.count()).isEqualTo(1)

        repository.deleteAll()
        assertThat(repository.count()).isEqualTo(0)
    }

    @Test
    fun `save entities`() {
        val dummies = listOf(
            createDummy(),
            createDummy(),
            createDummy()
        )
        repository.saveAll(dummies)
        assertThat(repository.count().toInt()).isEqualTo(dummies.size)
    }

    @Test
    fun `save entities and find`() {
        val dummies = listOf(
            createDummy(),
            createDummy(),
            createDummy()
        )
        repository.saveAll(dummies)

        val target = dummies[0]
        val result = repository.findById(target.drwNo)
        assertThat(result.isPresent).isTrue
        assertThat(result.get().drwNo).isEqualTo(target.drwNo)
    }

    @Test
    fun `check created at`() {
        val saved = repository.save(createDummy())

        assertThat(saved.createdAt).isNotNull
    }
}