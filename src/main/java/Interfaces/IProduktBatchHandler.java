package Interfaces;

import DTO.ProduktBatchDTO;
import Exceptions.DALException;

import java.util.List;

public interface IProduktBatchHandler {

    ProduktBatchDTO getProduktBatch(int produktbatch) throws DALException;
    List<ProduktBatchDTO> getProduktBatchList() throws DALException;
    void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException;
    void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException;
    void deleteProduktBatch(int produktbatch) throws DALException;

}
