package com.github.hugovallada.livro

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface LivroRepository : JpaRepository<Livro, Long>{
    fun existsByTituloOrIsbn(titulo: String, isbn: String): Boolean
}