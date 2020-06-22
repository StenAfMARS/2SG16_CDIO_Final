package DTO;

public class RaavareDTO {
    public RaavareDTO(int raavareId, String raavareNavn, String leverandoer) {
        this.raavareID = raavareId;
        this.raavareNavn = raavareNavn;
        this.leverandoer = leverandoer;
    }
    int raavareID;
    String raavareNavn;
    String leverandoer;

    public int getRaavareID() {return raavareID;}

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public String getLeverandoer() {
        return leverandoer;
    }

    public void setRaavareID(int raavareID) {this.raavareID = raavareID;    }

    public void setRaavareNavn(String raavareNavn) {this.raavareNavn = raavareNavn;}

    public void setLeverandoer(String leverandoer) {this.leverandoer = leverandoer;}

    public RaavareDTO() {}
}
