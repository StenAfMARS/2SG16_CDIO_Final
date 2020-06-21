package DTO;

public class ReceptDTO {

    int receptId;
    String receptNavn;

    public ReceptDTO(int receptId, String receptNavn) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
    }

    public int getReceptID() {return receptId;}
    public String getReceptNavn() {return receptNavn;}

}
