package com.github.hugovallada.cliente

import com.github.hugovallada.localidade.Estado
import com.github.hugovallada.localidade.EstadoRepository
import com.github.hugovallada.localidade.PaisRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.Valid

@Controller("/clientes")
@Validated
class ClienteController(private val estadoRepository: EstadoRepository,
                        private val clienteRepository: ClienteRepository,
                        private val paisRepository: PaisRepository
                        )

{

    @Post
    fun cadastrarCliente(@Body @Valid clienteRequest: ClienteRequest):HttpResponse<Void> {
        if(clienteRequest.estadoId != null && !estadoRepository.existsById(clienteRequest.estadoId)){
            return HttpResponse.unprocessableEntity()
        }

        if(estadoRepository.existsByPaisId(clienteRequest.paisId) && clienteRequest.estadoId == null){
            return HttpResponse.unprocessableEntity()
        }


        if(clienteRepository.existsByEmailOrDocumento(clienteRequest.email, clienteRequest.documento)){
            return HttpResponse.unprocessableEntity()
        }

        val estado  = if(clienteRequest.estadoId != null) estadoRepository.findById(clienteRequest.estadoId) else null
        val pais = paisRepository.findById(clienteRequest.paisId)

        if(estado != null){
            if(estado.isPresent){
                if(estado.get().pais.id != pais.get().id) {
                    return HttpResponse.unprocessableEntity()
                }
            }
        }

        if(estado != null && estado.isPresent) {
            clienteRepository.save(clienteRequest.toModel(pais = pais.get(), estado = estado.get()))
        } else {
            println(pais.get().nome)
            clienteRepository.save(clienteRequest.toModel(pais.get(), null))
        }



        return HttpResponse.status(HttpStatus.CREATED)


    }

}