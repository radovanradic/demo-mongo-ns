package com.example
import com.example.v1.BananaRepoV1
import com.example.v1.BananaV1
import com.example.v1.FruitRepoV1
import com.example.v1.FruitV1
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class DemoMongoFruitTest {

    @Inject
    lateinit var fruitRepoV1: FruitRepoV1

    @Inject
    lateinit var bananaRepoV1: BananaRepoV1
    @Test
    fun testFruitV1() {
        val fruit = fruitRepoV1.save(FruitV1("123"))

        val bananas = setOf(
            bananaRepoV1.save(BananaV1("1", fruit)),
            bananaRepoV1.save(BananaV1("2", fruit)),
            bananaRepoV1.save(BananaV1("3", fruit)),
        )

        fruit.bananas.addAll(bananas)
        fruitRepoV1.update(fruit)

        val loadedFruit = fruitRepoV1.findById(fruit.id).get()
        Assertions.assertEquals(3, loadedFruit.bananas.size)
    }

}
