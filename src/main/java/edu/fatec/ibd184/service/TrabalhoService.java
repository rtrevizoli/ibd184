package edu.fatec.ibd184.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.fatec.ibd184.entity.Trabalho;
import edu.fatec.ibd184.reporitory.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repo;

    public Trabalho novo(Trabalho trabalho)
    {
        if (trabalho.getTitulo() == null ||
                trabalho.getTitulo().isBlank() ||
                trabalho.getGrupo() == null ||
                trabalho.getGrupo().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Titulo ou grupo vazio");

        return repo.save(trabalho);
    }

    public List<Trabalho> findAll()
    {
        return repo.findAll();
    }

    public List<Trabalho> findByTituloContainingIgnoreCaseAndNotaGreaterThan(String palavra, Integer notaMinima)
    {
        return repo.findByTituloContainingIgnoreCaseAndNotaGreaterThan(palavra, notaMinima);
    }
    
}
