package com.github.hugovallada.categoria

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid


@Controller("/categorias")
@Validated
class CategoriaController(val categoriaRepository: CategoriaRepository) {

    @Post
    fun cadastrarCategoria(@Body @Valid categoriaRequest: CategoriaRequest): HttpResponse<Void> {

        if(categoriaRepository.existsByNome(categoriaRequest.nome)){
            return HttpResponse.unprocessableEntity()
        }

        categoriaRepository.save(categoriaRequest.toModel())
        return HttpResponse.status(HttpStatus.CREATED)
    }


}