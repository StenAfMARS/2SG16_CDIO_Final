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

    public ReceptKomponentDTO() {
    }
}
