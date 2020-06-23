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

    public void setRbID(int rbID) {
        this.rbID = rbID;
    }

    public void setRaavareID(int raavareID) {
        this.raavareID = raavareID;
    }

    public void setMaengde(double maengde) {
        this.maengde = maengde;
    }

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
