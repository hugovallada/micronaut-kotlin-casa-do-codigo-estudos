package com.github.hugovallada.cliente

import com.github.hugovallada.localidade.Estado
import com.github.hugovallada.localidade.Pais
import javax.persistence.ManyToOne

data class ClienteRequest(
        val nome: String,
        val email: String,
        val sobrenome: String,
        val endereco: String,
        val documento: String,
        val complemento: String,
        val cidade: String,
        val estadoId: Long?=null,
        val paisId: Long,
        val cep: String,
        val telefone: String
) {
    fun toModel(pais: Pais, estado: Estado?): Cliente{
        return Cliente(nome = nome, email = email, sobrenome = sobrenome, endereco = endereco, documento = documento, complemento = complemento, cidade = cidade, estado = estado, pais = pais, cep = cep, telefone = telefone)
    }
}
