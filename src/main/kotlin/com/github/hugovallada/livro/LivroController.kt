package com.github.hugovallada.livro

import com.github.hugovallada.autor.AutorRepository
import com.github.hugovallada.categoria.CategoriaRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid
import kotlin.streams.toList

@Controller("/livros")
@Validated
class LivroController(val livroRepository: LivroRepository, val categoriaRepository: CategoriaRepository, val autorRepository: AutorRepository) {


    @Post
    fun criarNovoLivro(@Body @Valid livroRequest: LivroRequest): HttpResponse<Void> {

        if(livroRepository.existsByTituloOrIsbn(livroRequest.titulo, livroRequest.isbn)){
            return HttpResponse.unprocessableEntity()
        }

        val categoria = categoriaRepository.findById(livroRequest.categoriaId).get()
        val autor = autorRepository.findById(livroRequest.autorId).get()

        val livro = livroRequest.toModel(categoria, autor)

        livroRepository.save(livro)

        return HttpResponse.status(HttpStatus.CREATED)


    }

    @Get
    fun listarLivros(): HttpResponse<List<LivroResponse>> {
        val livros = livroRepository.findAll()
        val livroResponse = livros.stream().map { livro -> LivroResponse(livro.id!!, livro.titulo) }.toList()
        return HttpResponse.ok(livroResponse)
    }

    @Get("/{id}")
    fun buscarPorId(@PathVariable id: Long): HttpResponse<DetalheLivroResponse> {
        val livroOpt = livroRepository.findById(id);

        if(livroOpt.isEmpty){
            return HttpResponse.notFound()
        }

        val livro = livroOpt.get()

        val response = DetalheLivroResponse(livro.id!!, livro.titulo, livro.isbn, livro.resumo, livro.numPag)
        return HttpResponse.ok(response)
    }

}