package edu.fatec.ibd184.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fatec.ibd184.entity.Vaga;
import edu.fatec.ibd184.service.VagaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/vaga")
public class VagaController
{
    @Autowired
    private VagaService service;

    @PostMapping
    public ResponseEntity<Vaga> novo(@RequestBody Vaga vaga)
    {
        vaga.fillDefaults();
        return ResponseEntity.ok(service.novo(vaga));
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> buscarTodos()
    {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Vaga>> buscarPorTipoESalario(
        @RequestParam(required = false) String palavra,
        @RequestParam(required = false) Float salarioMinimo)
    {
        return ResponseEntity.ok(service.buscarPorTipoESalario(palavra, salarioMinimo));
    }
}
