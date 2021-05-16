package com.github.hugovallada.autor

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Autor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,
        val email: String,
        val nome: String,
        @CreationTimestamp
        val instanteDeRegistro: LocalDateTime? = null,
        val descricao: String
){

}
