package com.github.hugovallada.cliente

import com.github.hugovallada.localidade.Estado
import com.github.hugovallada.localidade.Pais
import javax.persistence.*

@Entity
data class Cliente(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?=null,
        val nome: String,
        val email: String,
        val sobrenome: String,
        val endereco: String,
        val documento: String,
        val complemento: String,
        val cidade: String,
        @ManyToOne
        val estado: Estado?=null,
        @ManyToOne
        val pais: Pais,
        val cep: String,
        val telefone: String
)
