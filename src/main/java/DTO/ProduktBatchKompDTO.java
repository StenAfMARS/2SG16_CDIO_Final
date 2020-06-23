package DTO;

public class ProduktBatchKompDTO {
    public ProduktBatchKompDTO(int pbId, int rbId, double tara, double netto, int oprId) {
        this.pbID = pbId;
        this.rbID = rbId;
        this.tara = tara;
        this.netto = netto;
        this.oprID = oprId;
    }
    int pbID;
    int rbID;
    double tara;
    double netto;
    int oprID;

    public ProduktBatchKompDTO() {
    }

    public int getPbID() {
        return pbID;
    }

    public int getRbID() {
        return rbID;
    }

    public double getTara() {
        return tara;
    }

    public double getNetto() {
        return netto;
    }

    public int getOprID() {
        return oprID;
    }

}
