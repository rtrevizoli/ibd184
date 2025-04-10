package edu.fatec.ibd184.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vga_vaga")
public class Vaga
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)    
    @Column(name = "vga_id")
    private Long id;

    @Column(name = "vga_descricao")
    private String descricao;

    @Column(name = "vga_salario", nullable = false)
    private Float salario;

    @Column(name = "vga_data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "vga_data_termino")
    private LocalDate dataTermino;

    @Column(name = "vga_tipo")
    private String tipo;

    public Vaga() {}

    public void fillDefaults()
    {
        if (dataAbertura == null)
        {
            dataAbertura = LocalDate.now();
        }
    }

}
