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

    public RaavareDTO() {
    }
}
