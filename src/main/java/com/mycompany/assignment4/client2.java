
package com.mycompany.assignment4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket client2=new Socket("localhost",1515);
            DataInputStream input=new DataInputStream(client2.getInputStream());
             DataOutputStream out=new DataOutputStream(client2.getOutputStream());
             Scanner scan = new Scanner(System.in);
             //System.out.println("I am client2");
             
             while(true) {
                out.writeUTF("Hello server! Please send me the pizza order");
                System.out.println(input.readUTF());

                System.out.println("\n\n" + input.readUTF());

                while (true) {
                    String flavor = scan.nextLine();
                    out.writeUTF(flavor);
                    if (input.readBoolean()) {
                        break;
                    } else {
                        System.out.println(input.readUTF());
                    }
                }

                System.out.println(input.readUTF());
                String size = scan.nextLine();

                out.writeUTF(size);
                System.out.println(input.readUTF());

                int quan = scan.nextInt();
                out.writeInt(quan);

                scan.nextLine();
                System.out.println(input.readUTF());
                String ans = scan.nextLine();
                out.writeUTF(ans);

                if(ans.equalsIgnoreCase("no"))
                    break;
            }

            System.out.println("Total price: " + input.readDouble());
        
        }catch (IOException ex) {
            Logger.getLogger(client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
