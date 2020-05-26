package com.olmedo.examen.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {
    @Id
    @Column(name = "c_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_categoria;

    @NotEmpty(message = "No puede estar vacio")
    @Size(message = "No debe tener mas de 50 caracteres", max = 50)
    @Column(name = "s_categoria")
    private String s_categoria;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Categoria() {
    }

    public Integer getC_categoria() {
        return c_categoria;
    }

    public void setC_categoria(Integer c_categoria) {
        this.c_categoria = c_categoria;
    }

    public String getS_categoria() {
        return s_categoria;
    }

    public void setS_categoria(String s_categoria) {
        this.s_categoria = s_categoria;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}