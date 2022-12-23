package com.example

import io.micronaut.core.annotation.NonNull
import io.micronaut.data.model.naming.NamingStrategy

class CustomNamingStrategy : NamingStrategy {

    @NonNull
    override fun mappedName(@NonNull name: String): String {
        return "R$name"
    }
}