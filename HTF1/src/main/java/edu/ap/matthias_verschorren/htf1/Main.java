package edu.ap.matthias_verschorren.htf1;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            Account.GetAccounts();
        }
        catch(IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
