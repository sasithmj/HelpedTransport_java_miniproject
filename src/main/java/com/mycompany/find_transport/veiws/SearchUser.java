package com.mycompany.find_transport.veiws;

import java.util.Scanner;
import java.util.Vector;

import com.mycompany.find_transport.controllers.UserContoller;
import com.mycompany.find_transport.controllers.gotoXY;

public class SearchUser {
    gotoXY gotoXY=new gotoXY();
    Scanner scn =new Scanner(System.in);
    UserContoller usercontroller=new UserContoller();
    public Vector search() { // Method for login veiw
        System.out.print("\033[1;34m");
        System.out.format("%90s","--------------------------------\n");
        System.out.format("%90s","|          SEARCH USER         |\n");
        System.out.format("%90s","--------------------------------\n");
        System.out.print("\033[0m");

        System.out.format("%65s","Name: \n");
        System.out.format("%71s","NIC number: \n");
        System.out.format("%80s","Driver or Passenger: \n");
        gotoXY.gotoXYCoords(5, 80);
        String name = scn.nextLine();
        gotoXY.gotoXYCoords(6, 80);
        String nic = scn.next();
        gotoXY.gotoXYCoords(7, 80);
        String userstate = scn.next();

        Vector state = usercontroller.searchUser(name, nic,userstate);

     
        return state;
    }
    
}
