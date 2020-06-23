/*
    Peter M. Skaarup
 */
package DTO;

public class ReceptKomponentDTO {
    public ReceptKomponentDTO(int receptId, int raavareId, double nonNetto, double tolerance) {
        this.receptID = receptId;
        this.raavareID = raavareId;
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
    }

    int receptID;
    /** raavare id i området 1-99999999 vælges af brugerne */
    int raavareID;
    /** nominel nettomængde i området 0,05 - 20,0 kg */
    double nonNetto;
    /** tolerance i området 0,1 - 10,0 % */
    double tolerance;

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public int getRaavareID() {
        return raavareID;
    }

    public void setRaavareID(int raavareID) {
        this.raavareID = raavareID;
    }

    public double getNonNetto() {
        return nonNetto;
    }

    public void setNonNetto(double nonNetto) {
        this.nonNetto = nonNetto;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public ReceptKomponentDTO() {
    }
}
