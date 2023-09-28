package it.contrader.authenticationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OspedaleDTO {

    private Long id;

    private String nome;

    private String indirizzo;

    private String provincia;

    private String citta;

    private String descrizione;

    private Long userId;
}
