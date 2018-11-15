/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmusic.utility;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author DHan
 */
public class MusicPlayer {
    private String URL;
    public MusicPlayer(String URL){
        this.URL = URL;
    }
    public void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            AudioInputStream stream = AudioSystem.getAudioInputStream(new URL("http://antiserver.kuwo.cn/anti.s?type=convert_url&rid=MUSIC_324244&format=aac|mp3&response=url"));
            AudioFormat format = stream.getFormat();
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
//            if (format.getEncoding() == AudioFormat.Encoding.ULAW) {
//                stream.read();
//            } else if (format.getEncoding() == AudioFormat.Encoding.ULAW) {
//                
//            }

       

    
}
    
}
