package com.olmedo.examen.Domain;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema ="public", name = "cat_libro")
public class Libro {
    @Id
    @Column(name = "c_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_libro;

    @NotEmpty(message = "No puede estar vacio")
    @Size(message = "No debe tener mas de 500 caracteres", max = 500)
    @Column(name = "s_titulo")
    private String s_titulo;


    @NotEmpty(message = "No puede estar vacio")
    @Size(message = "No debe tener mas de 150 caracteres", max = 150)
    @Column(name = "s_autor")
    private String s_autor;

    @Column(name = "b_estado")
    private Boolean b_estado;

    @NotEmpty(message = "No puede estar vacio")
    @Size(message = "No debe tener mas de 10 caracteres", max = 10)
    @Column(name = "s_isbn")
    private String s_isbn;

    @Column(name="f_ingreso")
    private Date f_ingreso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_categoria")
    private Categoria categoria;


    public Integer getC_libro() {
        return c_libro;
    }

    public void setC_libro(Integer c_libro) {
        this.c_libro = c_libro;
    }

    public String getS_titulo() {
        return s_titulo;
    }

    public void setS_titulo(String s_titulo) {
        this.s_titulo = s_titulo;
    }

    public String getS_autor() {
        return s_autor;
    }

    public void setS_autor(String s_autor) {
        this.s_autor = s_autor;
    }

    public Boolean getB_estado() {
        return b_estado;
    }

    public void setB_estado(Boolean b_estado) {
        this.b_estado = b_estado;
    }

    public String getS_isbn() {
        return s_isbn;
    }

    public void setS_isbn(String s_isbn) {
        this.s_isbn = s_isbn;
    }

    public Date getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(Date f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }




    public Libro() {
    }
}
