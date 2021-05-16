package com.github.hugovallada.localidade

data class PaisRequest(val nome: String) {
    fun toModel(): Pais {
        return Pais(nome = nome)
    }
}
