package com.github.hugovallada.cliente

import com.github.hugovallada.localidade.Estado
import com.github.hugovallada.localidade.Pais
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class ClienteRequest(
        @field:NotBlank
        val nome: String,
        @field:NotBlank @field:Email
        val email: String,
        @field:NotBlank
        val sobrenome: String,
        @field:NotBlank
        val endereco: String,
        @field:NotBlank
        val documento: String,
        @field:NotBlank
        val complemento: String,
        @field:NotBlank
        val cidade: String,
        val estadoId: Long?=null,
        @field:NotNull @field:Positive
        val paisId: Long,
        @field:NotBlank @field:NotNull
        val cep: String,
        @field:NotBlank
        val telefone: String
) {
    fun toModel(pais: Pais, estado: Estado?): Cliente{
        return Cliente(nome = nome, email = email, sobrenome = sobrenome, endereco = endereco, documento = documento, complemento = complemento, cidade = cidade, estado = estado, pais = pais, cep = cep, telefone = telefone)
    }
}
