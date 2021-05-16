package com.github.hugovallada.livro

data class DetalheLivroResponse(
        val id: Long,
        val titulo: String,
        val isbn : String,
        val resumo: String,
        val numPag: Number
)
