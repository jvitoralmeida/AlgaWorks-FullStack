package com.algaworks.algamoney.algamoneyapi.resource;

import java.util.List;

import com.algaworks.algamoney.algamoneyapi.model.Categoria;
import com.algaworks.algamoney.algamoneyapi.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoriaResource
 */
@RestController
@RequestMapping(path = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}