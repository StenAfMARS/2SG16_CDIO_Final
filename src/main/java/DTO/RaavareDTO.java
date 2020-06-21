package DTO;

public class RaavareDTO {
    public RaavareDTO(int raavareId, String raavareNavn, String leverandoer) {
        this.raavareId = raavareId;
        this.raavareNavn = raavareNavn;
        this.leverandoer = leverandoer;
    }
    int raavareId;
    String raavareNavn;
    String leverandoer;

    public int getRaavareId() {
        return raavareId;
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
