/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ap.matthias_verschorren.htf1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author matto
 */
public class oldMethodForGet {
    String readLine = null;
        String output = "";
        JSONArray jarray = new JSONArray();

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
            if (obj.has("challenge")) {
                if (obj.getString("challenge").equals("Decode the following string")) {
                    jarray.put(obj);
                }
            }
            
            output = response.toString();
        } 
        else {
            System.out.println("GET NOT WORKED");
        }
        return jarray.toString();
    }
}
