package com.andensonsilva.cursomc.services;

import com.andensonsilva.cursomc.domain.Categoria;
import com.andensonsilva.cursomc.repositories.CategoriaRepository;
import com.andensonsilva.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria buscar(Integer id) {

        Optional<Categoria> cat = this.repository.findById(id);

        return cat.orElseThrow(() -> new ObjectNotFoundException(
                "Categoria não encontrada. Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

}
