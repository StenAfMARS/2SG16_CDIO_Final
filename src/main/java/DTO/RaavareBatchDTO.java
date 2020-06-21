package DTO;

public class RaavareBatchDTO {
    public RaavareBatchDTO(int rbId, int raavareId, double maengde) {
        this.rbId = rbId;
        this.raavareId = raavareId;
        this.maengde = maengde;
    }
    int rbId;
    int raavareId;
    double maengde;

    public RaavareBatchDTO() {
    }
}
