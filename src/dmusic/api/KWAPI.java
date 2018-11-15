/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmusic.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/**
 *
 * @author DHan
 */
public class KWAPI {
    private String APIAddr="http://search.kuwo.cn/r.s?all=%s&ft=music&itemset=web_2013&client=kt&pn=%s&rn=%s&rformat=json&encoding=utf8";
    private String searchContent;
    private String numOfPages;
    private String numOfRecordsPerPage;
    public KWAPI(){
//        this.searchContent = searchContent;
        this.numOfPages="1";
        this.numOfRecordsPerPage = "10";
    }
    public KWAPI(String searchContent,String numOfPages){
//        this.searchContent = searchContent;
        this.numOfPages=numOfPages;
        this.numOfRecordsPerPage = "10";
    }
    public String makeURL(String searchContent){
        return String.format(this.APIAddr, searchContent, this.numOfPages,this.numOfRecordsPerPage);

    }
    public String search(String searchContent){
        int responseCode=0;
        String url = makeURL(searchContent);
        System.out.println(url);
        try{
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
        responseCode = con.getResponseCode();
            if (responseCode == 200){
                return readResponse(con);
            }else{
                return null;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void parseJson(String response){
        
    }
    private String readResponse(HttpURLConnection con){
        try{
            BufferedReader in = new BufferedReader(
                 new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                   response.append(inputLine);
                }
            in.close();
            return response.toString();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
}
