package Handlers;

import DTO.RaavareBatchDTO;
import Exceptions.DALException;
import Interfaces.IRaavareBatchHandler;

import java.util.List;

public class RaavareBatchHandler implements IRaavareBatchHandler {
    @Override
    public RaavareBatchDTO getRaavareBatch(int RaavareBatchId) throws DALException {
        return null;
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
        return null;
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
        return null;
    }

    @Override
    public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {

    }

    @Override
    public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {

    }
}
