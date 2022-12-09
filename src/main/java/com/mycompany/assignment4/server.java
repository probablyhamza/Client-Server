/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.assignment4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serversocket=new ServerSocket(1515);
            
            Socket client1=serversocket.accept();
            Socket client2=serversocket.accept();
            
              DataInputStream input1=new DataInputStream(client1.getInputStream());
            DataInputStream input2=new DataInputStream(client2.getInputStream());
            DataOutputStream out2=new DataOutputStream(client2.getOutputStream());
              DataOutputStream out1=new DataOutputStream(client1.getOutputStream());
              
              Scanner scan = new Scanner(System.in);
              double total = 0;
              
              while(true){
                  System.out.println("Client1: " + input1.readUTF());
                  out1.writeUTF("Grill Harley Resturent Menu\n" +
                        "       *********Beef Burger*********\n" +
                        "           Sandwich        Meal\n" +
                        "Grill Harley   3.25JD      4.45\n" +
                        "White Mushroom  3.75JD     4.95JD\n" +
                        "Maxican        3.75JD      4.95JD\n" +
                        "Grill Harley Resturent Menu\n" +
                        "       *********Chicken Burger*********\n" +
                        "           Sandwich        Meal\n" +
                        "Grill Harley   3.25JD      4.45JD\n" +
                        "White Mushroom  3.75JD     4.95JD\n" +
                        "Maxican        3.75JD      4.95JD\n" +
                        "       **********Kids Meal**********\n" +
                        "Happy Meal     2.25JD\n");
                  
                  out1.writeUTF("Please enter type of Burger (Beef,Chicken, Kids)");
                  
                  String Burger;
                  while(true){
                      Burger = (input1.readUTF()).toLowerCase();
                      if(Burger.equals("beef") || Burger.equals("chicken") || Burger.equals("kids")){
                          out1.writeBoolean(true);
                          break;
                      }
                      else{
                          out1.writeBoolean(false);
                          out1.writeUTF("Wrong input... try again");
                      }
                      
                  }
                  out1.writeUTF("Please enter your flavor for beef and chicken :( Grill Harley, White Mushroom, maxican), and for kids (happy meal)");
                  String flavor = (input1.readUTF()).toLowerCase();
                  
                  out1.writeUTF("Do you want sandwich or meal?");
                  String MorS = (input1.readUTF().toLowerCase());
                  
                  out1.writeUTF("Please enter the quantity:");
                  int quantity = input1.readInt();
                  
                  if (Burger.equals("kids")) {
                    total += (2.25 * quantity);
                } else {
                    if (MorS.equals("meal")) {
                        if (flavor.equals("grill harley")) {
                            total += 4.45 * quantity;
                        } else {
                            total += 4.95 * quantity;
                        }
                    } else {
                        if (flavor.equals("grill harley")) {
                            total += 3.25 * quantity;
                        } else {
                            total += 3.75 * quantity;
                        }
                    }
                  }
                  out1.writeUTF("Do you want to choose another burger?");
                  String answer = input1.readUTF().toLowerCase();
                  
                  if(answer.equals("no"))
                      break;
              }
              
              out1.writeDouble(total);
              
              double total2 = 0;
              
              while(true){
                  System.out.println("Client2: " + input2.readUTF());
                  out2.writeUTF("Grill Harley Resturent Menu\n" +
                        "       *********Pizza********\n\n" +
                        "               S       M       L\n" +
                        "Margarita      2.00JD  2.50JD  4.50JD\n" +
                        "Vegtabales     2.50JD  3.25JD  4.50JD\n" +
                        "Chicken        2.75JD  3.25JD  5.00JD");
                  
                  out2.writeUTF("Please enter your flavor of Pizza (Margarita, Vegetables, Chicken)");
                  
                  
                  String flavour;
                  while(true){
                      flavour = input2.readUTF();
                    if (flavour.equalsIgnoreCase("margarita") || flavour.equalsIgnoreCase("vegetables") || flavour.equalsIgnoreCase("Chicken")) {
                        out2.writeBoolean(true);
                        break;
                    } else {
                        out2.writeBoolean(false);
                        out2.writeUTF("“Wrong input... try again");
                    }
                  }
                  out2.writeUTF("Please enter the size of your pizza(S,M,L)");
                String size = input2.readUTF();

                out2.writeUTF("How many boxes you want of this pizza size?");
                int quan = input2.readInt();

                if (flavour.equalsIgnoreCase("margarita")) {
                    switch (size.toLowerCase()) {
                        case "s":
                            total2 += (quan * 2);
                            break;
                        case "m":
                            total2 += (quan * 2.5);
                            break;
                        case "l":
                            total2 += (quan * 4.5);
                            break;
                    }
                } else if (flavour.equalsIgnoreCase("vegetables")) {
                    switch (size.toLowerCase()) {
                        case "s":
                            total2 += (quan * 2.5);
                            break;
                        case "m":
                            total2 += (quan * 3.25);
                            break;
                        case "l":
                            total2 += (quan * 4.5);
                            break;
                    }
                } else {
                    switch (size.toLowerCase()) {
                        case "s":
                            total2 += (quan * 2.75);
                            break;
                        case "m":
                            total2 += (quan * 3.25);
                            break;
                        case "l":
                            total2 += (quan * 5);
                            break;
                    }
                }
                out2.writeUTF("“Do you want to choose another pizza?");
                String ans2 = input2.readUTF();

                if(ans2.equalsIgnoreCase("no"))
                    break;
              }
              out2.writeDouble(total2);
        }
        catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
