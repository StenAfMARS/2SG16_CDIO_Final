package Handlers;

import DTO.ReceptDTO;
import Exceptions.DALException;
import Interfaces.IReceptHandler;

import java.util.LinkedList;
import java.util.List;

public class ReceptHandler implements IReceptHandler {


    @Override
    public ReceptDTO getRecept(int receptId) throws DALException {
        return null;
    }

    @Override
    public List<ReceptDTO> getReceptList() throws DALException {
        return null;
    }

    @Override
    public void createRecept(ReceptDTO recept) throws DALException {

    }

    @Override
    public void updateRecept(ReceptDTO recept) throws DALException {

    }
}
