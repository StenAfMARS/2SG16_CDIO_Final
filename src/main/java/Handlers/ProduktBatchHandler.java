package Handlers;

import DTO.ProduktBatchDTO;
import Exceptions.DALException;
import Interfaces.IProduktBatchHandler;

import java.util.List;

public class ProduktBatchHandler implements IProduktBatchHandler {
    @Override
    public ProduktBatchDTO getProduktBatch(int produktbatch) throws DALException {
        return null;
    }

    @Override
    public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
        return null;
    }

    @Override
    public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {

    }

    @Override
    public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {

    }

    @Override
    public void deleteProduktBatch(int produktbatch) throws DALException {

    }
}
