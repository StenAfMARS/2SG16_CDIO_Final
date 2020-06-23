package DTO;

public class ProduktBatchDTO {

    public ProduktBatchDTO(int pbId, int status, int receptId){
        this.pbID = pbId;
        this.status = status;
        this.receptID = receptId;
    }
    // Produkt Batch id 1-99999999
    int pbID;
    // Ikke påbegyndt = 0/ Under Produktion =  1/ Afsluttet = 2
    int status;
    // Recept Id 1-99999999
    int receptID;

    public ProduktBatchDTO() {
    }

    public void setPbID(int pbID) {
        this.pbID = pbID;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public int getPbID() {
        return pbID;
    }

    public int getStatus() {
        return status;
    }


    public int getReceptID() {
        return receptID;
    }
}
