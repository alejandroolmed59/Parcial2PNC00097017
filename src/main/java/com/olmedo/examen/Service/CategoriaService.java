package com.olmedo.examen.Service;


import com.olmedo.examen.Domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaService {
    public void insertarCategoria(Categoria categoria) throws DataAccessException;
    public List<Categoria> findAll() throws DataAccessException;
}
