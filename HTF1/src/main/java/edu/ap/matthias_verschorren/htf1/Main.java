package edu.ap.matthias_verschorren.htf1;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            String json = Account.getAccounts();
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
                    String solvedAnswer = MorseDecoder.decodeMorseString(challengeParameters);
                    JSONObject crackedAccount = new JSONObject(Account.postAnswer(bankID, solvedAnswer));
                    
                    
                    int amountToSteal = crackedAccount.getInt("amount");
                    Account.internalTransfer(bankID,"83ea55a9-e4e7-42e1-8b11-eb95f0777f37", amountToSteal, solvedAnswer);
                }
                
            }
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
}




//ONZE REKENING 83ea55a9-e4e7-42e1-8b11-eb95f0777f37 ww: zcxzrvncrkye