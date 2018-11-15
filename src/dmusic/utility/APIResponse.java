/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmusic.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author DHan
 */
public class APIResponse {
    private String response;
    private String absList;
    public APIResponse(String response){
        this.response = response;
        //this.absList = getAbsList();
    }
    
    public List<JSONObject> getAbsList(){
        try{
        String temp = ToolsBox.strToJSON(response).getString("abslist");
//        System.out.println(temp);
        
        return getSongList(temp);
        
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
        private List<JSONObject> getSongList(String absList){
            List<String> resultList = ToolsBox.strToArrayList(absList.replace("[","").replace("]",""));
            List<JSONObject> nameAndURL = new ArrayList();
            for (int i=0;i< resultList.size();i++){
                Map<String, String> myMap = new HashMap<>();
                myMap = ToolsBox.strToHashMap(resultList.get(i).substring(1));
//                System.out.println(myMap);
//                System.out.println(myMap.get("SONGNAME").replace("&nbsp;",""));
                try{
                JSONObject songInfo = new JSONObject();
                songInfo.put("name",myMap.get("SONGNAME").replace("&nbsp;",""));
                songInfo.put("url", myMap.get("MUSICRID"));
                nameAndURL.add(songInfo);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    return null;
                }
            }
            System.out.println(nameAndURL);
            return nameAndURL;
    }
}
