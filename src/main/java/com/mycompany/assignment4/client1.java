/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.assignment4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class client1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
           Socket client1=new Socket("localhost",1515);
              DataOutputStream out=new DataOutputStream(client1.getOutputStream());
            DataInputStream input=new DataInputStream(client1.getInputStream());
            //System.out.println("I am client1");
            Scanner scan = new Scanner(System.in);
            
            while(true){
                out.writeUTF("Hello server! Please send me the burger order");
                System.out.println(input.readUTF());
                System.out.println("\n\n" + input.readUTF());
                
                while(true){
                    String burger = scan.nextLine();
                    out.writeUTF(burger);
                    if(input.readBoolean()){
                        break;
                    }
                    else{
                        System.out.println(input.readUTF());
                    }
                }
                
                System.out.println(input.readUTF());
                String flavor = scan.nextLine();
                out.writeUTF(flavor);
                
                
                System.out.println(input.readUTF());
                String type = scan.nextLine();
                out.writeUTF(type);

                System.out.println(input.readUTF());
                int quantity = scan.nextInt();
                out.writeInt(quantity);

                System.out.println(input.readUTF());
                scan.nextLine();
                String ans = scan.nextLine();
                out.writeUTF(ans);

                if(ans.equals("no"))
                    break;
            }
            System.out.println("Total prie:" + input.readDouble());
            
            
            
       } catch (IOException ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
