package DTO;

public class ReceptKomponentDTO {
    public ReceptKomponentDTO(int receptId, String receptNavn, int raavareId, double nomNetto, double tolerance) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
        this.raavareId = raavareId;
        this.nomNetto = nomNetto;
        this.tolerance = tolerance;
    }
    int receptId;
    /** raavare id i området 1-99999999 vælges af brugerne */
    String receptNavn;
    /** nominel nettomængde i området 0,05 - 20,0 kg */
    int raavareId;
    double nomNetto;
    /** tolerance i området 0,1 - 10,0 % */
    double tolerance;

}
