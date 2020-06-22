package DTO;

public class ReceptKomponentDTO {
    public ReceptKomponentDTO(int receptId, int raavareId, double nomNetto, double tolerance) {
        this.receptID = receptId;
        this.raavareID = raavareId;
        this.nomNetto = nomNetto;
        this.tolerance = tolerance;
    }
    int receptID;
    /** raavare id i området 1-99999999 vælges af brugerne */
    String receptNavn;
    /** nominel nettomængde i området 0,05 - 20,0 kg */
    int raavareID;
    double nomNetto;
    /** tolerance i området 0,1 - 10,0 % */
    double tolerance;

    public ReceptKomponentDTO() {
    }
}
