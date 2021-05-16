package com.github.hugovallada.autor

import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AutorRequest(
        @field:NotBlank
        val nome: String,
        @field:Email @field:NotBlank
        val email: String,
        @field:NotBlank @Size(max = 400)
        val descricao: String
){
    fun toModel():Autor {
        return Autor(nome = nome,  email = email, descricao = descricao)
    }
}
