package Handlers;

import DTO.ProduktBatchKompDTO;
import DTO.ReceptKomponentDTO;
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

    public void afmålt(int laborantID, int pbID, int rbID, double mTara, double mNetto){
        ProduktBatchHandler pbHandler = new ProduktBatchHandler();
        ReceptHandler receptHandler = new ReceptHandler();
        RaavareBatchHandler rbHandler = new RaavareBatchHandler();

        int receptID = pbHandler.getProduktBatch(pbID).getReceptID();
        int raavareID = rbHandler.getRaavareBatch(rbID).getRaavareID();

        System.out.println(receptID);
        System.out.println(rbID);
        System.out.println(raavareID);

        ReceptKomponentDTO receptKomponent = receptHandler.getReceptKomponent(receptID, raavareID);

        System.out.println(receptKomponent);

        double nonNetto = receptKomponent.getNonNetto();    // Vægt mål
        double tolerance = receptKomponent.getTolerance();   // Tolerance i procent

        if ((100 - tolerance)/100 * nonNetto < mNetto
                && mNetto < (100 + tolerance)/100 * nonNetto){

            new ProduktBatchHandler().createProduktBatchKompDTO(
                    new ProduktBatchKompDTO(pbID, rbID, mTara, mNetto, laborantID)
            );
        } else {
            throw new DALException("Incorrect weight");
        }
    }
}
