package DTO;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserDTO implements Serializable {
    private static final String userNameMatch = "^.{2,20}$";
    private static final String passwordMatch  = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!-/:-?\\[-`{-~]).{8,45}$";
    private static final String iniMatch = "^[A-Za-z]{2,4}$";
    private static final String cprMatch = "^[0-9]{6}-[0-9]{4}$";

    private int userID;
    private String userName;
    private String password;
    private String ini;
    private String cpr;
    private String roles;

    public UserDTO(int userID, String userName, String password, String ini, String cpr, String roles) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.ini = ini;
        this.cpr = cpr;
        this.roles = roles;
    }

    public UserDTO(){
        int userID = -1;
        String userName = "";
        String password = "";
        String ini = "";
        String cpr = "";
        String roles = "";
    }

    public void randomizePassword(){
        while (!setPassword(generatePassword(8))) {}
    }

    private String generatePassword(int passwordLength){
        Random random = new Random();

        StringBuilder sb = new StringBuilder(passwordLength);

        for (int i = 0; i < passwordLength; i++) {
            sb.append((char)(random.nextInt(('~' - '!') + 1) + '!'));
        }

        return sb.toString();
    }

    public int getUserID() {
        return userID;
    }

    public boolean setUserID(int userID) {
        this.userID = userID;
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public boolean setUserName(String userName) {
        if (userName.matches(userNameMatch)){
            this.userName = userName;
            return true;
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (password.matches(passwordMatch)){
            this.password = password;
            return true;
        }
        return false;
    }

    public String getIni() {
        return ini;
    }

    public boolean setIni(String ini) {
        if (ini.matches(iniMatch)){
            this.ini = ini;
            return true;
        }
        return false;
    }

    public String getCpr() {
        return cpr;
    }

    public boolean setCpr(String cpr) {
        if (cpr.matches(cprMatch)){
            this.cpr = cpr;
            return true;
        }
        return false;
    }

    public String getRoles() {
        return roles;
    }

    public boolean setRoles(String roles) {
        this.roles = roles;
        return true;
    }
}