package com.olmedo.examen.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.olmedo.examen.Domain.Libro;
import com.olmedo.examen.Domain.Categoria;
import com.olmedo.examen.Service.LibroService;
import com.olmedo.examen.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private LibroService libroService;

    @RequestMapping(value = "/newLibro", method = RequestMethod.GET)
    public ModelAndView newLibro() {
        ModelAndView mav = new ModelAndView();
        List<Categoria> categoriaList = categoriaService.findAll();
        mav.addObject("libro", new Libro());
        mav.addObject("categoriaList", categoriaList);
        mav.setViewName("newLibro");
        return mav;
    }
    @RequestMapping(value = "/newLibro", method = RequestMethod.POST)
    public ModelAndView insertarLibro(@Valid @ModelAttribute Libro libro, BindingResult result){
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            List<Categoria> categoriaList = categoriaService.findAll();
            mav.addObject("categoriaList", categoriaList);
            mav.setViewName("newLibro");
        }
        else{
            try {
                libroService.insertarLibro(libro);
                mav.addObject("msg", "Libro guardado con exito");
                mav.setViewName("index");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
        return mav;
    }
    @RequestMapping(value = "/newCategory", method = RequestMethod.POST)
    public ModelAndView insertarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result){
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            mav.setViewName("newCategory");
        }
        else {
            try {
                categoriaService.insertarCategoria(categoria);
                mav.addObject("msg", "Categoria guardada con exito");
                mav.setViewName("index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mav;
    }
    @RequestMapping(value = "/newCategory", method = RequestMethod.GET)
    public ModelAndView newCategory() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("categoria", new Categoria());
        mav.setViewName("newCategory");
        return mav;
    }

    @RequestMapping(value = "/verLibros", method = RequestMethod.GET)
    public ModelAndView verLibros() {
        ModelAndView mav = new ModelAndView();
        List<Libro> librosList = libroService.findAll();
        System.out.println(librosList.get(0).getCategoria().getS_categoria());
        mav.addObject("librosList", librosList);
        mav.setViewName("verLibros");
        return mav;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
       // mav.addObject("categoria", new Categoria());
        mav.setViewName("index");
        return mav;
    }



}