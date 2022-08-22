package com.mycompany.find_transport.veiws;

import java.util.Scanner;
import java.util.Vector;

import com.mycompany.find_transport.Find_transport;
import com.mycompany.find_transport.controllers.Authcontroller;
import com.mycompany.find_transport.controllers.UpdateController;
import com.mycompany.find_transport.controllers.gotoXY;

public class Updatetraveldata extends Find_transport {
    gotoXY gotoXY = new gotoXY();
    Authcontroller authnew = new Authcontroller();
    UpdateController update = new UpdateController();
    TravelDetailveiw tdveiw = new TravelDetailveiw();
    Navigation nav = new Navigation();

    Scanner scn = new Scanner(System.in);

    public void updateData() {
        System.out.print("\033[1;34m");
        System.out.format("%90s", "--------------------------------\n");
        System.out.format("%90s", "|         CHANGE DATA          |\n");
        System.out.format("%90s", "--------------------------------\n");
        System.out.print("\033[0m");

        System.out.format("%73s", "Phone Number: \n");
        System.out.format("%69s", "Password: \n");
        gotoXY.gotoXYCoords(5, 75);
        int phonenumber = scn.nextInt();
        gotoXY.gotoXYCoords(6, 75);
        String psw = scn.next();
        int state = authnew.userLogin(phonenumber, psw);

        if (state == 1) {
            Vector dt = update.searchVehical(phonenumber);
            //tdveiw.showTravelDetails(dt);

            clear();
            System.out.print("\033[1;34m");
            System.out.format("%90s", "--------------------------------\n");
            System.out.format("%90s", "|         TRAVEL DETAILS       |\n");
            System.out.format("%90s", "--------------------------------\n");
            System.out.print("\033[0m");
            System.out.format("%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s\n\n",
                    "Id", "Driver name", "NIC Number", "Phone Number", "Date", "Time", "Vehical Number", "Vehical type",
                    "Seats", "From", "To", "Massage");
            for (int i = 0; i < dt.size(); i++) {
                String doc = (String) dt.elementAt(i);
                String[] datalist = doc.split(",");
                for (int j = 0; j < datalist.length; j++) {
                    System.out.format("%-17s", datalist[j]);
                }
                System.out.println();

            }
            // int navstate=nav.showNavigation(15);
        }
        System.out.println("\033[1;31m");
        System.out.print("Enter ID to delete: ");
        System.out.print("\033[0m");
        int id = scn.nextInt();
        update.deleteFile(id);
        int navstate = nav.showNavigation(15);
    }

}
