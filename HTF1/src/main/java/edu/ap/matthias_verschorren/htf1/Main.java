package edu.ap.matthias_verschorren.htf1;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            String json = Account.getAccountsWithMorsecode();
            JSONObject obj = new JSONObject(json);
            JSONArray jArray = obj.getJSONArray("content");
            System.out.println(jArray);
            for (int i = 0; i < jArray.length(); i++){
                JSONObject loopObj = jArray.getJSONObject(i);
                String challenge = loopObj.getString("challenge");
                if (challenge.equals("Decode the following string")) {
                    System.out.println(challenge);
                    String challengeParameters = loopObj.getString("challengeParameters");
                    String bankID = loopObj.getString("id");
                    System.out.println(challengeParameters);
                    System.out.println(MorseDecoder.decodeMorseString(challengeParameters));
                    System.out.println(Account.postAnswer(bankID, MorseDecoder.decodeMorseString(challengeParameters)));
                }
                
            }
            //tring bankID = obj.getString("id");
            //String challengeParameters = obj.getString("challengeParameters");
            //System.out.println(bankID);
            //System.out.println(MorseDecoder.decodeMorseString(challengeParameters));
            
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
