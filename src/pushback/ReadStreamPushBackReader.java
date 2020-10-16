/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pushback;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ReadStreamPushBackReader {

    public static void main(String[] args) throws FileNotFoundException {
        File coba = new File("coba.txt");
        String cek = "Joss";
        PushbackReader reader = new PushbackReader(new FileReader(coba), 100);
        System.out.println("Coba.txt read :  ");
        char[] value = new char[(int) coba.length()];
        try {
            reader.read(value);
            System.out.println("Before Unread : " + new String(value));
            
            reader.unread(value);
            
            if (new String(value).contains(cek)) {
                value = new char[8];
                reader.read(value);
                System.out.println("After Unread : " + cek);
            }else{
                System.out.println("Word not found");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadStreamPushBackReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
