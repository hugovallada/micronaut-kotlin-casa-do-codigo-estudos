package com.github.hugovallada.cliente

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {
    fun existsByEmailOrDocumento(email: String, documento: String):Boolean
}