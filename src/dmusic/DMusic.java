/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmusic;
import dmusic.ui.*;
import dmusic.network.Network;
/**
 *
 * @author DHan
 */
public class DMusic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitScreen initScreen = new InitScreen();
        initScreen.setVisible(true);
        Network network = new Network();
        System.out.print(network.networkStatus);
        if (network.networkStatus){
            initScreen.setVisible(false);
            new MainScreen().setVisible(true);
        }
    }
    
}
