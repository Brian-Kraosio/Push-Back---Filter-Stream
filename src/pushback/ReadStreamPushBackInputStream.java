/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pushback;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ReadStreamPushBackInputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int lines = 1;
        int word = 0;
        
        System.out.println("Input The File Destination");
        System.out.println("For Example : E:/TUGAS/Jarkom/Semester 5/Stream/JavaLibrary5/Coba.txt");
        System.out.print("Destination : ");
        String input = sc.nextLine();
        File file = new File(input);
        
        PushbackInputStream stream = new PushbackInputStream(new FileInputStream(file), 100);
        System.out.println("Coba.txt read :  ");
        byte[] value = new byte[(int) file.length()];
        
        try {
            stream.read(value);
            System.out.println("Read : " + new String(value));
            System.out.println("Information : ");
            
            

            if (new String(value).contains("\n")) {
                lines++;
            }
            String[] arr = new String(value).split("\\s+");
            word += arr.length;
            System.out.println("Total Lines : " + lines);
            System.out.println("Total Words : " + word);
            System.out.println("Total Char : " + file.length());

        } catch (IOException ex) {
            Logger.getLogger(ReadStreamPushBackInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
