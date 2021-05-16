package com.github.hugovallada.localidade

data class EstadoRequest(val nome: String, val paisId: Long){
    fun toModel(pais: Pais): Estado {
        return Estado(nome = nome, pais = pais)
    }
}
