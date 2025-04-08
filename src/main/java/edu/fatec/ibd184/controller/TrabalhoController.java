package edu.fatec.ibd184.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fatec.ibd184.entity.Trabalho;
import edu.fatec.ibd184.service.TrabalhoService;

@RestController
@CrossOrigin
@RequestMapping(value = "trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @PostMapping
    public ResponseEntity<Trabalho> novo(@RequestBody Trabalho trabalho)
    {
        return ResponseEntity.ok(service.novo(trabalho));
    }

    @GetMapping
    public ResponseEntity<List<Trabalho>> buscarTodos()
    {
        return ResponseEntity.ok(service.buscarTodos());
    }
    
}
