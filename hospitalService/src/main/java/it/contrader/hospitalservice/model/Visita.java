package it.contrader.hospitalservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tipologia;

    @Column(unique = true)
    private String nome;

    private String descrizione;

    private Double prezzo;

    private Long codice;

    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL)
    private List<VisitaImage> visitaImmagini;

    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL)
    private List<Time> orari;
}
