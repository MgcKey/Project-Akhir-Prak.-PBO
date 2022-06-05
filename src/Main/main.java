package Main;

import View.*; 
import Controller.*;
import Model.*;

public class main {
    public static void main(String[] args) {
        formLogin fl = new formLogin();
        modelApotek ma = new modelApotek();
        new controllerLogin(ma, fl);
    }
}
