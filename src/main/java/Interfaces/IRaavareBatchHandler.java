package Interfaces;

import DTO.RaavareBatchDTO;

import java.util.List;

public interface IRaavareBatchHandler {
    RaavareBatchDTO getRaavareBatch(int RaavareBatchId) throws DALException;
    List<RaavareBatchDTO> getRaavareBatchList() throws DALException;

    //den returnerer den liste over raavarebatch med den specifikke vareID
    List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException;
    void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException;
    void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException;

}
