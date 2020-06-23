package DTO;

public class ReceptDTO {

    int receptID;
    String receptNavn;

    public ReceptDTO(int receptId, String receptNavn) {
        this.receptID = receptId;
        this.receptNavn = receptNavn;
    }

    public int getReceptID() {return receptID;}
    public String getReceptNavn() {return receptNavn;}

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }
    public void setReceptNavn(String receptNavn) {
        this.receptNavn = receptNavn;
    }

    public ReceptDTO() {
    }
}
