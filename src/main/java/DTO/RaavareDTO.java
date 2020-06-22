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

    public int getRaavareID() {
        return raavareID;
    }

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public String getLeverandoer() {
        return leverandoer;
    }
    public RaavareDTO() {
    }
}
