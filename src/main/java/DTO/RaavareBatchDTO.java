package DTO;

public class RaavareBatchDTO {
    public RaavareBatchDTO(int rbId, int raavareId, double maengde) {
        this.rbID = rbId;
        this.raavareID = raavareId;
        this.maengde = maengde;
    }
    int rbID;
    int raavareID;
    double maengde;

    public RaavareBatchDTO() {
    }

    public double getMaengde() {
        return maengde;
    }

    public int getRbID() {
        return rbID;
    }

    public int getRaavareID() {
        return raavareID;
    }
}
