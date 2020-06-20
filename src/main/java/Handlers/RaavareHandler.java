package Handlers;

import DTO.RaavareDTO;
import Exceptions.DALException;
import Interfaces.IRaavareHandler;

import java.util.List;

public class RaavareHandler implements IRaavareHandler {
    @Override
    public RaavareDTO getRaavare(int raavareId) throws DALException {
        return null;
    }

    @Override
    public List<RaavareDTO> getRaavareList() throws DALException {
        return null;
    }

    @Override
    public void createRaavare(RaavareDTO raavare) throws DALException {

    }

    @Override
    public void updateRaavare(RaavareDTO raavare) throws DALException {

    }
}
