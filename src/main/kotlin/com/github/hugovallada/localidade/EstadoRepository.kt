package com.github.hugovallada.localidade

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface EstadoRepository : JpaRepository<Estado, Long>{
    fun existsByNomeAndPaisId(nome: String, id: Long): Boolean
    fun existsByPaisId(id: Long): Boolean
}
