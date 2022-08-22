/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.find_transport.veiws;

import java.util.Scanner;

import com.mycompany.find_transport.Models.User;
import com.mycompany.find_transport.controllers.Authcontroller;
import com.mycompany.find_transport.controllers.gotoXY;

/**
 *
 * @author Pc
 */
public class Home {
    gotoXY gotoXY=new gotoXY();
    Authcontroller auth=new Authcontroller();
    User userdata= auth.getUser();
    Scanner scn=new Scanner(System.in);
    public int showNavigation(){
        System.out.print("\033[1;34m");
        System.out.format("%90s","--------------------------------\n");
        System.out.format("%90s","|              HOME            |\n");
        System.out.format("%90s","--------------------------------\n");
        System.out.print("\033[0m");

        
        System.out.format("%72s","-------------\n");
        System.out.format("%72s","| 1.Passenger|\n");
        System.out.format("%72s","-------------\n");
        gotoXY.gotoXYCoords(5, 75);
        System.out.print(" -------------\n");
        gotoXY.gotoXYCoords(6, 75);
        System.out.print("|   2.Driver  |\n");
        gotoXY.gotoXYCoords(7, 75);
        System.out.println(" -------------\n");

        
        System.out.format("%72s","3.Search Users ");
       
        System.out.format("%18s\n\n","4.Update travel ");

        System.out.format("%72s","Continue as a: ");
        int state=scn.nextInt();
        return state;

    }
    
}
