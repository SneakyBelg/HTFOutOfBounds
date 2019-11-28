package edu.ap.matthias_verschorren.htf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class Account {
    public static String getAccountsWithMorsecode() throws IOException {
        URL urlForGetRequest = new URL("http://vault.bewire.org/accounts");
        String readLine = null;
        String output = "";
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
        
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        String json = response.toString();
        JSONObject obj = new JSONObject(json);
            output = response.toString();
        } 
        else {
            System.out.println("GET NOT WORKED");
        }
        return output;
    }
}
