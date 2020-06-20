package Interfaces;

import DTO.RaavareDTO;
import Exceptions.DALException;

import java.util.List;

public interface IRaavareHandler {
    RaavareDTO getRaavare(int raavareId) throws DALException;
    List<RaavareDTO> getRaavareList() throws DALException;
    void createRaavare(RaavareDTO raavare) throws DALException;
    void updateRaavare(RaavareDTO raavare) throws DALException;

}
