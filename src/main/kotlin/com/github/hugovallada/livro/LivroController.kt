package com.github.hugovallada.livro

import com.github.hugovallada.autor.AutorRepository
import com.github.hugovallada.categoria.CategoriaRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/livros")
class LivroController(val livroRepository: LivroRepository, val categoriaRepository: CategoriaRepository, val autorRepository: AutorRepository) {


    @Post
    fun criarNovoLivro(@Body livroRequest: LivroRequest): HttpResponse<Void> {

        if(livroRepository.existsByTituloOrIsbn(livroRequest.titulo, livroRequest.isbn)){
            return HttpResponse.unprocessableEntity()
        }

        val categoria = categoriaRepository.findById(livroRequest.categoriaId).get()
        val autor = autorRepository.findById(livroRequest.autorId).get()

        val livro = livroRequest.toModel(categoria, autor)

        livroRepository.save(livro)

        return HttpResponse.status(HttpStatus.CREATED)


    }

}