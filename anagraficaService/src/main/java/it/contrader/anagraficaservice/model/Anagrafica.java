package it.contrader.anagraficaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Anagrafica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cognome;

    private String nazionalita;

    private String indirizzo;

    private String genere;

    private String provincia;

    private String citta;

    private LocalDate dataDiNascita;

    @Column(unique = true)
    private Long userId;
}
