package DTO;

public class ProduktBatchDTO {

    public ProduktBatchDTO(int pbId, int status, int receptId){
        this.pbId = pbId;
        this.status = status;
        this.receptId = receptId;
    }
    // Produkt Batch id 1-99999999
    int pbId;
    // Ikke påbegyndt = 0/ Under Produktion =  1/ Afsluttet = 2
    int status;
    // Recept Id 1-99999999
    int receptId;
}
