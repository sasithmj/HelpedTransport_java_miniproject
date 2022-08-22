package com.mycompany.find_transport.veiws;

import com.mycompany.find_transport.controllers.PassengerController;
import com.mycompany.find_transport.controllers.gotoXY;
import java.util.Scanner;

public class PassengerForm {
    gotoXY gotoXY = new gotoXY();
    Scanner scn = new Scanner(System.in);
    Navigation nav = new Navigation();

    public void showPassengerForm() {
        int column = 20;
        System.out.print("\033[1;34m--------------------------------\n");
        System.out.print("|        PASSENGER FORM        |\n");
        System.out.print("--------------------------------\033[0m\n\n");

        System.out.print("Full Name: \n");
        System.out.print("NIC number: \n");
        System.out.print("Phone number \n\n");
        System.out.print("\033[0;34m---------Vehical Detail---------\033[0m\n\n");
        System.out.print("Seats Wanted: \n\n");
        System.out.print("\033[0;34m--------Route information--------\033[0m\n\n");
        System.out.print("Date: \n");
        System.out.print("Departure Time: \n");
        System.out.print("Start From: \n");
        System.out.print("Destination: \n");
        System.out.print("Any massege: \n");

        gotoXY.gotoXYCoords(6, column);
        String name = scn.nextLine();
        gotoXY.gotoXYCoords(7, column);
        String nic = scn.nextLine();
        gotoXY.gotoXYCoords(8, column);
        int phone = scn.nextInt();
        scn.nextLine();
        gotoXY.gotoXYCoords(12, column);
        int seats = scn.nextInt();
        scn.nextLine();
        gotoXY.gotoXYCoords(16, column);
        String date = scn.nextLine();
        gotoXY.gotoXYCoords(17, column);
        String time = scn.nextLine();
        gotoXY.gotoXYCoords(18, column);
        String stfrom = scn.nextLine();
        gotoXY.gotoXYCoords(19, column);
        String destinaton = scn.nextLine();
        gotoXY.gotoXYCoords(20, column);
        String msg = scn.nextLine();
        gotoXY.gotoXYCoords(21, column);

        PassengerController pfrom = new PassengerController(name,
                nic, phone, seats, date, time, stfrom, destinaton, msg);
        int navstate=nav.showNavigation(22);
    }
}
