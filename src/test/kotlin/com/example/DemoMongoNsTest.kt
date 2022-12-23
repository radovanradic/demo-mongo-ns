package com.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class DemoMongoNsTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var repository: MyRepository

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun testRepo() {
        val entity = MyEntity()
        entity.name = "Test"
        repository.save(entity)
        Assertions.assertNotNull(entity.id)
    }

}
