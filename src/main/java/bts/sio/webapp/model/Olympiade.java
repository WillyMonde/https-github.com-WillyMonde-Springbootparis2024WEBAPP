package bts.sio.webapp.model;


import lombok.Data;

@Data

public class Olympiade {

    private int id;
    private String numero;
    private int annee;
    private String ville;
    private Pays pays;

}

