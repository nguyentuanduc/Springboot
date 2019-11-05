package com.springboot.controller;

import java.util.List;

import com.springboot.model.Note;
import com.springboot.model.Product;
import com.springboot.repository.NoteRepository;
import com.springboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class HomeController {


    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(value="/home" , method=RequestMethod.GET)  
    public String index() {
        return "index";
    }

    @RequestMapping(value="/about" , method=RequestMethod.GET)  
    public String about() {
        return "about";
    }

    @RequestMapping(value="/products" , method=RequestMethod.GET)  
    public String products(Model model) {
        List<Product> list = productRepository.findAll();
        System.out.println(list.size());
        for (Product product : list) {
            System.out.println(product);
        }
        model.addAttribute("products",list);

        return "products";
    }

    @GetMapping("/listnotes")
    public String getAllNotes(Model model) {
        List<Note> notes = noteRepository.findAll();
        System.out.println(notes.size());
        model.addAttribute("notes",notes);
        return "notes";
    }
}
