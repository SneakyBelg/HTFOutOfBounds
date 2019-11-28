package edu.ap.matthias_verschorren.htf1;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class Account {
    public static String getAccounts() throws IOException {
        URL url = new URL("http://vault.bewire.org/accounts");
        String readLine = null;
        String output = "";
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
            output = response.toString();
        } 
        return output;
    }
    public static String postAnswer(String id, String answerSol) throws Exception {
        URL url = new URL("http://vault.bewire.org/accounts/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        String output = "";
        String JsonInputString = "{\"answer\": \"" + answerSol + "\"}";
        connection.connect();
        
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = JsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);           
        }
        
        try(BufferedReader br = new BufferedReader(
            new InputStreamReader(connection.getInputStream(), "utf-8"))) {
              StringBuilder response = new StringBuilder();
              String responseLine = null;
              while ((responseLine = br.readLine()) != null) {
                  response.append(responseLine.trim());
                  output = response.toString();
              }
              System.out.println(response.toString());
        }
        return output;
    }
    public static String internalTransfer(String originID, String destinationID, double amount, String answerSol) throws Exception {
        URL url = new URL("http://vault.bewire.org/internal-transfer/" + originID + "/" + destinationID);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        String output = "";
        String JsonInputString = "{ \"amount\": " + amount + ", \"originAccountAnswer\": \"" + answerSol + "\"}";
        connection.connect();
        
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = JsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);           
        }
        try(BufferedReader br = new BufferedReader(
  new InputStreamReader(connection.getInputStream(), "utf-8"))) {
    StringBuilder response = new StringBuilder();
    String responseLine = null;
    while ((responseLine = br.readLine()) != null) {
        response.append(responseLine.trim());
    }
    System.out.println(response.toString());
}
        getOwnAccount();
        return "";
    }
    
    
    public static void getOwnAccount() throws Exception{
        URL url = new URL("http://vault.bewire.org/accounts/83ea55a9-e4e7-42e1-8b11-eb95f0777f37");
        String readLine = null;
        String output = "";
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
        
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
            System.out.println(response.toString());
        } in .close();
        String json = response.toString();
            output = response.toString();
        } 
    }
}
