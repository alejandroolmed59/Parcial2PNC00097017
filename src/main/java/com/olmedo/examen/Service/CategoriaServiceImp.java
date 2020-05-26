package com.olmedo.examen.Service;


import com.olmedo.examen.Dao.CategoryDAO;

import com.olmedo.examen.Domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    @Transactional
    public void insertarCategoria(Categoria categoria) throws DataAccessException {
        categoryDAO.insertarCategoria(categoria);
    }

    @Override
    public List<Categoria> findAll() throws DataAccessException {
        return categoryDAO.findAll();
    }
}
