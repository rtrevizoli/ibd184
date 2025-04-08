package edu.fatec.ibd184.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tra_trabalho")
public class Trabalho
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    private Long id;

    @Column(name = "tra_titulo")
    private String titulo;

    @Column(name = "tra_data_hora_entrega")
    private LocalDateTime dataHoraEntrega;

    @Column(name = "tra_descricao")
    private String descricao;

    @Column(name = "tra_grupo")
    private String grupo;

    @Column(name = "tra_nota")
    private Integer nota;

    @Column(name = "tra_justificativa")
    private String justificativa;

    public Trabalho(String titulo, LocalDateTime dataHoraEntrega)
    {
        setTitulo(titulo);
        setDataHoraEntrega(dataHoraEntrega);
    }

    public Trabalho() {}

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega)
    {
        if (dataHoraEntrega == null)
        {
            dataHoraEntrega = LocalDateTime.now();
        }
        
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public LocalDateTime getDataHoraEntrega()
    {
        return dataHoraEntrega;
    }

    public void setGrupo(String grupo)
    {
        this.grupo = grupo;
    }

    public String getGrupo()
    {
        return grupo;
    }
}
