package com.github.hugovallada.livro

import com.github.hugovallada.autor.Autor
import com.github.hugovallada.categoria.Categoria
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.ManyToOne
import javax.validation.constraints.*
import kotlin.math.max

class LivroRequest(
        @NotBlank
        val titulo: String,
        @NotBlank
        val sumario: String,
        @NotBlank @Size(max = 500)
        val resumo: String,
        @NotNull @Positive @Min(20)
        val preco: BigDecimal,
        @NotNull @Positive @Min(100)
        val numPag : Number,
        @NotBlank
        val isbn: String,
        @Future
        val dataPublicacao: LocalDateTime,
        @NotNull @Positive
        val categoriaId: Long,
        @NotNull @Positive
        val autorId: Long,
) {

    fun toModel(categoria: Categoria, autor: Autor): Livro{
        return Livro(titulo = titulo, sumario = sumario,resumo = resumo, preco = preco, numPag = numPag,isbn = isbn,dataPublicacao = dataPublicacao,categoria = categoria, autor = autor)
    }

}
