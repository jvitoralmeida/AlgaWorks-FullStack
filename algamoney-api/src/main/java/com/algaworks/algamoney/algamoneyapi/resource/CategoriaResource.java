package com.algaworks.algamoney.algamoneyapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.algaworks.algamoney.algamoneyapi.model.Categoria;
import com.algaworks.algamoney.algamoneyapi.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * CategoriaResource
 */
@RestController
@RequestMapping(path = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> buscarPeloId(@PathVariable Long id) {
        Optional<Categoria> categoriaBuscada = categoriaRepository.findById(id);
        if (categoriaBuscada.isPresent())
            return ResponseEntity.ok(categoriaBuscada.get());
        return ResponseEntity.notFound().build();
    }
}