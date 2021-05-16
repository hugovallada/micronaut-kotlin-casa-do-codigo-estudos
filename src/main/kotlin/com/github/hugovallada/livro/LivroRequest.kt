package com.github.hugovallada.livro

import com.github.hugovallada.autor.Autor
import com.github.hugovallada.categoria.Categoria
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.ManyToOne
import javax.validation.constraints.*
import kotlin.math.max

class LivroRequest(
        @field:NotBlank
        val titulo: String,
        @field:NotBlank
        val sumario: String,
        @field:NotBlank @field:Size(max = 500)
        val resumo: String,
        @field:NotNull @field:Positive @field:Min(20)
        val preco: BigDecimal,
        @field:NotNull @field:Positive @field:Min(100)
        val numPag : Number,
        @field:NotBlank
        val isbn: String,
        @field:Future
        val dataPublicacao: LocalDate,
        @field:NotNull @field:Positive
        val categoriaId: Long,
        @field:NotNull @field:Positive
        val autorId: Long,
) {

    fun toModel(categoria: Categoria, autor: Autor): Livro{
        return Livro(titulo = titulo, sumario = sumario,resumo = resumo, preco = preco, numPag = numPag,isbn = isbn,dataPublicacao = dataPublicacao,categoria = categoria, autor = autor)
    }

}
