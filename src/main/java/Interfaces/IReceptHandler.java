package Interfaces;

import DTO.ReceptDTO;
import Exceptions.DALException;

import java.util.List;

public interface IReceptHandler {
    ReceptDTO getRecept(int receptId) throws DALException;
    List<ReceptDTO> getReceptList() throws DALException;
    void createRecept(ReceptDTO recept) throws DALException;
    void updateRecept(ReceptDTO recept) throws DALException;

}
