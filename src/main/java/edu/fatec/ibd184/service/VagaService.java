package edu.fatec.ibd184.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.fatec.ibd184.entity.Vaga;
import edu.fatec.ibd184.reporitory.VagaRepository;

@Service
public class VagaService
{
    @Autowired
    private VagaRepository repo;

    public Vaga novo(Vaga vaga)
    {
        if (!vaga.getTipo().equalsIgnoreCase("CLT") && !vaga.getTipo().equalsIgnoreCase("PJ"))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de vaga inválido ("+vaga.getTipo()+")");
        }

        if (vaga.getDataTermino() != null && vaga.getDataTermino().isBefore(vaga.getDataAbertura()))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data termino vem antes da data de abertura ?");
        }

        return repo.save(vaga);
    }

    public List<Vaga> buscarTodos()
    {
        return repo.findAll();
    }

    public List<Vaga> buscarPorTipoESalario(String palavra, Float salarioMinimo)
    {
        return repo.findByTipoContainingIgnoreCaseOrSalarioGreaterThan(palavra, salarioMinimo)
            .stream()
            .filter(v -> v.getSalario() != null)
            .toList();
    }
}
