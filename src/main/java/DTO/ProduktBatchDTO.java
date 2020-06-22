package DTO;

public class ProduktBatchDTO {

    public ProduktBatchDTO(int pbId, int status, int receptId){
        this.pbID = pbId;
        this.status = status;
        this.receptId = receptId;
    }
    // Produkt Batch id 1-99999999
    int pbID;
    // Ikke påbegyndt = 0/ Under Produktion =  1/ Afsluttet = 2
    int status;
    // Recept Id 1-99999999
    int receptId;

    public ProduktBatchDTO() {
    }

    public int getPbID() {
        return pbID;
    }

    public int getStatus() {
        return status;
    }


    public int getReceptId() {
        return receptId;
    }
}
