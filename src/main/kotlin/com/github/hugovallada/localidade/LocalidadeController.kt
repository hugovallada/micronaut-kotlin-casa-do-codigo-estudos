package com.github.hugovallada.localidade

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/localidades")
class LocalidadeController (private val paisRepository: PaisRepository,private val estadoRepository: EstadoRepository){


    @Post("/pais")
    fun cadastrarPais(@Body paisRequest: PaisRequest): HttpResponse<Void>{
        if(paisRepository.existsByNome(paisRequest.nome)){
            return HttpResponse.unprocessableEntity()
        }

        paisRepository.save(paisRequest.toModel())
        return HttpResponse.status(HttpStatus.CREATED)
    }

    @Post("/estado")
    fun cadastrarEstado(@Body estadoRequest: EstadoRequest):HttpResponse<Void>{

        val pais = paisRepository.findById(estadoRequest.paisId)

        if(pais.isEmpty){
            return HttpResponse.status(HttpStatus.UNPROCESSABLE_ENTITY)
        }

        if(estadoRepository.existsByNomeAndPaisId(estadoRequest.nome, estadoRequest.paisId)){
            return HttpResponse.unprocessableEntity()
        }

        estadoRepository.save(estadoRequest.toModel(pais.get()))

        return HttpResponse.status(HttpStatus.CREATED)

    }


}