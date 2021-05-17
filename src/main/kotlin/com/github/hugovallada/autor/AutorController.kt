package com.github.hugovallada.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid


@Controller("/autores")
@Validated
class AutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastrarAutor(@Body @Valid autorRequest: AutorRequest): HttpResponse<Autor> {
        if(autorRepository.existsByEmail(autorRequest.email)){
            return HttpResponse.status<Autor?>(HttpStatus.UNPROCESSABLE_ENTITY)
        }

        val autor = autorRepository.save(autorRequest.toModel())
        return HttpResponse.created(autor);
    }


    @Get("/{id}")
    fun buscarAutorPorId(@PathVariable id: Long): HttpResponse<Autor> {
        val autor = autorRepository.findById(id)

        if(autor.isEmpty){
            return HttpResponse.notFound()
        }

        return HttpResponse.ok(autor.get())

    }
}