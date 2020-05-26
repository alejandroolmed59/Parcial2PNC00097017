package com.olmedo.examen.Dao;

import com.olmedo.examen.Domain.Libro;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface LibroDAO {
    public void insertarLibro(Libro libro) throws DataAccessException;
    public List<Libro> findAll() throws DataAccessException;
}
