package com.mycompany.find_transport.veiws;

import java.util.Scanner;
import java.util.Date;

import com.mycompany.find_transport.controllers.DriverFormController;
import com.mycompany.find_transport.controllers.gotoXY;

public class DriverForm {
    gotoXY gotoXY=new gotoXY();
    Scanner scn=new Scanner(System.in);
    Navigation nav=new Navigation();
    public void showDriverForm(){
        int column=20;
        System.out.print("\033[1;34m--------------------------------\n");
        System.out.print("|           DRIVER FORM        |\n");
        System.out.print("--------------------------------\033[0m\n\n");
        System.out.print("Id: \n");
        System.out.print("Full Name: \n");
        System.out.print("NIC number: \n");
        System.out.print("Phone number \n\n");
        System.out.print("\033[0;34m---------Vehical Detail---------\033[0m\n\n");
        System.out.print("Vehical number: \n");
        System.out.print("Vehical type: \n");
        System.out.print("Seats Available: \n\n");
        System.out.print("\033[0;34m--------Route information--------\033[0m\n\n");
        System.out.print("Date: \n");
        System.out.print("Departure Time: \n");
        System.out.print("Start From: \n");
        System.out.print("Destination: \n");
        System.out.print("Any massege: \n");

        gotoXY.gotoXYCoords(6, column);
        int id=scn.nextInt();
        scn.nextLine();
        gotoXY.gotoXYCoords(7, column);
        String name=scn.nextLine();
        gotoXY.gotoXYCoords(8, column);
        String nic=scn.nextLine();
        gotoXY.gotoXYCoords(9, column);
        int phone=scn.nextInt();
        scn.nextLine();
        gotoXY.gotoXYCoords(13, column);
        String vehicalnum=scn.nextLine();
        gotoXY.gotoXYCoords(14, column);
        String vehicaltype=scn.nextLine();
        gotoXY.gotoXYCoords(15, column);
        int seats=scn.nextInt();
        scn.nextLine();
        gotoXY.gotoXYCoords(19, column);
        String date=scn.nextLine();
        gotoXY.gotoXYCoords(20, column);
        String time=scn.nextLine();
        gotoXY.gotoXYCoords(21, column);
        String stfrom=scn.nextLine();
        gotoXY.gotoXYCoords(22, column);
        String destinaton=scn.nextLine();
        gotoXY.gotoXYCoords(23, column);
        String msg=scn.nextLine();


        DriverFormController dfrom=new DriverFormController(name, nic,phone,seats,date,time,vehicalnum,vehicaltype, stfrom,destinaton,msg,id) ;
       
        int navstate=nav.showNavigation(25);
    }
    
}
