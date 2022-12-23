package com.example

import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository
import org.bson.types.ObjectId

@MongoRepository
interface MyRepository : CrudRepository<MyEntity, ObjectId>