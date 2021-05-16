package com.github.hugovallada.localidade

import javax.persistence.*

@Entity
data class Estado(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?=null,
        val nome: String,
        @ManyToOne
        val pais: Pais)
