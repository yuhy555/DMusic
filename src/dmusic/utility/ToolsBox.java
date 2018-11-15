/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmusic.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author DHan
 */
public class ToolsBox {
    
    
    public static List<String> strToArrayList (String input){
        List<String> list = new ArrayList<>(Arrays.asList(input.split("},")));
        return list;
    }
    public static JSONObject strToJSON(String input){
         try{
        JSONObject jsonObject = new JSONObject(input);
        return jsonObject;
        
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static Map<String,String> strToHashMap(String input){
        Map<String, String> myMap = new HashMap<String, String>();
        String[] pairs = input.split(",");
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            myMap.put(keyValue[0].substring(1,keyValue[0].length() - 1), keyValue[1].substring(1,keyValue[1].length()-1));
        }
        return myMap;
    }
}
