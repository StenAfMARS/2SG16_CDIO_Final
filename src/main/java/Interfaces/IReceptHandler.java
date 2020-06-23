/*
    Peter M. Skaarup
 */
package Interfaces;

import DTO.ReceptDTO;
import DTO.ReceptKomponentDTO;
import Exceptions.DALException;

import java.util.List;

public interface IReceptHandler {

    ReceptDTO getRecept(int receptId) throws DALException;
    List<ReceptDTO> getReceptList() throws DALException;
    void createRecept(ReceptDTO recept) throws DALException;
    void updateRecept(ReceptDTO recept) throws DALException;

    ReceptKomponentDTO getReceptKomponent(int recepID, int raavareID) throws DALException;
    List<ReceptKomponentDTO> getReceptKomponentList(int receptID) throws DALException;
    List<ReceptKomponentDTO> getReceptKomponentList() throws DALException;
    void createReceptKomponent(ReceptKomponentDTO receptkomponent) throws DALException;
    void updateReceptKomponent(ReceptKomponentDTO receptKomponent) throws DALException;

}
