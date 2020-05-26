package com.olmedo.examen.Dao;


import com.olmedo.examen.Domain.Libro;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public class LibroDAOImp implements LibroDAO {
    @PersistenceContext(unitName = "examen")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertarLibro(Libro libro) throws DataAccessException {
        libro.setF_ingreso(new Date());
        entityManager.persist(libro);
    }

    @Override
    public List<Libro> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.cat_libro");
        Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
        List <Libro> resulset = query.getResultList();
        return resulset;
    }
}
