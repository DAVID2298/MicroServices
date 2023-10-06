package it.contrader.hospitalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitaDTO {

    private Long id;

    private String tipologia;

    private String nome;

    private String descrizione;

    private Double prezzo;

    private Long codice;
}
