package DTO;

public class ProduktBatchKompDTO {
    public ProduktBatchKompDTO(int pbId, int rbId, double tara, double netto, int oprId) {
        this.pbId = pbId;
        this.rbId = rbId;
        this.tara = tara;
        this.netto = netto;
        this.oprId = oprId;
    }
    int pbId;
    int rbId;
    double tara;
    double netto;
    int oprId;

    public ProduktBatchKompDTO() {
    }
}
