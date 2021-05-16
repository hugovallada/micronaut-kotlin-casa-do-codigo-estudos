package com.github.hugovallada.categoria

import io.micronaut.core.annotation.Introspected
import io.micronaut.validation.Validated
import javax.validation.constraints.NotBlank

@Introspected
data class CategoriaRequest(
        @field:NotBlank
        val nome: String
){
    fun toModel(): Categoria{
        return Categoria(nome = nome)
    }
}
