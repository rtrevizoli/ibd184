package edu.fatec.ibd184.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.ibd184.entity.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    public List<Vaga> findByTipoContainingIgnoreCaseOrSalarioGreaterThan(String palavra, Float salarioMinimo);
}
