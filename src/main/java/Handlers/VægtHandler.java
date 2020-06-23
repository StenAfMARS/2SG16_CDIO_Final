package Handlers;

import DTO.ProduktBatchKompDTO;
import Exceptions.DALException;

public class VægtHandler {

    public int producer(int produktBatchID){
        int raavareID = 0;

        // Skaffe receptID fra produktBach med produktBatchID

        // Find alle receptKomponents med den rigtige receptID

        /*
        SQL statement der får alle receptKomponents med den rigtige receptID og som ikke matcher en produktbatchComponent på raavareID (skaffet medrbID)
         */

        // returner den første
        //
        // hvis tom kast en fejl

        return raavareID;
    }

    public void batchNummer(){
        double målteTaraBelastning = 0;  // Første måling
        double målteNettorVægt = 0;      // Anden måling

        double nonNetto = 0;    // Vægt mål
        double tolerance = 0;   // Tolerance i procent
        int laborantID = 0;

        int produktBatchID = 0;
        int receptID = 0;
        int raavareBatchNummer = 0;
        int raavareID = 0;

        double tempNetto = målteNettorVægt - målteTaraBelastning;

        if ((100 - tolerance)/100 * nonNetto < tempNetto
                && tempNetto < (100 + tolerance)/100 * nonNetto){

            new ProduktBatchHandler().createProduktBatchKompDTO(
                    new ProduktBatchKompDTO(produktBatchID, raavareBatchNummer, målteTaraBelastning, tempNetto, laborantID)
            );
        } else {
            throw new DALException("Incorrect weight");
        }
    }
}
