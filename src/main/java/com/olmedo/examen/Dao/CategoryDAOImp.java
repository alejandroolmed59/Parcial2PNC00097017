package com.olmedo.examen.Dao;


import com.olmedo.examen.Domain.Categoria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO {
    @PersistenceContext(unitName = "examen")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertarCategoria(Categoria categoria) throws DataAccessException {
        entityManager.persist(categoria);
    }
    @Override
    public List<Categoria> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM public.cat_categoria");
        Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
        List <Categoria> resulset = query.getResultList();
        return resulset;
    }
}
