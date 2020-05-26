package com.olmedo.examen.Dao;


import com.olmedo.examen.Domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoryDAO {
    public void insertarCategoria(Categoria categoria) throws DataAccessException;
    public List<Categoria> findAll() throws DataAccessException;
}
