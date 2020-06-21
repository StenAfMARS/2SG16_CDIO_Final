package DTO;

public class ReceptDTO {

    int receptId;
    String receptNavn;
    ReceptKomponentDTO receptKomponent;

    public ReceptDTO(int receptId, String receptNavn, ReceptKomponentDTO components) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
        this.receptKomponent = components;
    }

    public int getReceptID() {return receptId;}
    public String getReceptNavn() {return receptNavn;}
    public ReceptKomponentDTO getReceptKomponent() {return receptKomponent;}



}
