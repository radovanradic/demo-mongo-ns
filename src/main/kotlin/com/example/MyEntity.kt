package com.example

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import org.bson.types.ObjectId

@MappedEntity(namingStrategy = CustomNamingStrategy::class)
data class MyEntity (
    @GeneratedValue
    @field:Id
    var id: ObjectId? = null,
    var name: String? = null
)