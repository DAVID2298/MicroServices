package it.contrader.anagraficaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnagraficaDTO {


    private Long id;

    private String nome;

    private String cognome;

    private String nazionalita;

    private String indirizzo;

    private String genere;

    private String provincia;

    private String citta;

    private LocalDate dataDiNascita;

    private Long userId;
}
