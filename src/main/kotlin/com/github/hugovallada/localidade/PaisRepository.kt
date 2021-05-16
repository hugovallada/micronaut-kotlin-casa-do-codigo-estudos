package com.github.hugovallada.localidade

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PaisRepository : JpaRepository<Pais, Long>{

    fun existsByNome(nome: String): Boolean

}