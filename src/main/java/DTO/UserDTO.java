package DTO;

import java.util.List;

public class UserDTO {
    public UserDTO(int oprId, String oprNavn, String ini, List<String> roller) {
        this.oprId = oprId;
        this.oprNavn = oprNavn;
        this.ini = ini;
        this.roller = this.roller;
    }

    int oprId;
    /** Bruger navn (opr_navn) min. 2 max. 20 karakterer */
    String oprNavn;
    /** Bruger initialer min. 2 max. 4 karakterer */
    String ini;
    /** Bruger cpr-nr 10 karakterer */
    List<String> roller;

}
