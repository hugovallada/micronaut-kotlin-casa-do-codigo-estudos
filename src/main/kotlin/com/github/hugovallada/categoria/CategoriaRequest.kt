package com.github.hugovallada.categoria

import javax.validation.constraints.NotBlank

data class CategoriaRequest(
        @NotBlank
        val nome: String
){
    fun toModel(): Categoria{
        return Categoria(nome = nome)
    }
}
