package com.github.hugovallada.livro

import com.github.hugovallada.autor.Autor
import com.github.hugovallada.categoria.Categoria
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Livro(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val titulo: String,
        val sumario: String,
        val resumo: String,
        val preco: BigDecimal,
        val numPag : Number,
        val isbn: String,
        val dataPublicacao: LocalDateTime,
        @ManyToOne
        val categoria: Categoria,
        @ManyToOne
        val autor: Autor
)
