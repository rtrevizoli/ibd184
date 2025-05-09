package edu.fatec.ibd184.reporitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fatec.ibd184.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>
{
    public List<Trabalho> findByTituloContainingIgnoreCaseAndNotaGreaterThan(String palavra, Integer notaMinima);
}
