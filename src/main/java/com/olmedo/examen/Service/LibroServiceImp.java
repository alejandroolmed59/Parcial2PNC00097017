package com.olmedo.examen.Service;


import com.olmedo.examen.Dao.LibroDAO;
import com.olmedo.examen.Domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class LibroServiceImp implements LibroService {
    @Autowired
    LibroDAO libroDAO;

    @Override
    @Transactional
    public void insertarLibro(Libro libro) throws DataAccessException {
        libroDAO.insertarLibro(libro);
    }

    @Override
    public List<Libro> findAll() throws DataAccessException{
        return libroDAO.findAll();
    }
}
