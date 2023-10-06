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
public class PrenotazioneDTO {

    private Long id;

    private String data;

    private String ora;

    private Double prezzo;

    private Long userId;

    private String numPrenotazione;

    private Long visitaId;
}
