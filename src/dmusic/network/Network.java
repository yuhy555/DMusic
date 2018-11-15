/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmusic.network;

import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
/**
 *
 * @author DHan
 */
public class Network {
    private String networkName;
    private InetAddress networkIP;
    public boolean networkStatus;
    public Network(){
        this.networkStatus = this.isConnected();
        getNetworkName();
    }
    private boolean isConnected(){
        try { 
            URL url = new URL("https://www.google.com/"); 
            URLConnection connection = url.openConnection(); 
            connection.connect(); 
  
            System.out.println("Connection Successful"); 
            return true;
        } 
        catch (Exception e) { 
            System.out.println("Internet Not Connected"); 
            return false;
        } 
    } 
    private void getNetworkName(){
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);

        } catch (UnknownHostException e) {
            e.printStackTrace();

        }
    }
   
        
    
}
