package com.mycompany.find_transport.veiws;

import java.util.Vector;


import com.mycompany.find_transport.Find_transport;
import com.mycompany.find_transport.controllers.PassengerController;

public class TravelDetailveiw extends Find_transport {
    //PassengerController pc = new PassengerController();
    Navigation nav=new Navigation();
    public void showTravelDetails(Vector data) {
        clear();
        System.out.print("\033[1;34m");
        System.out.format("%90s","--------------------------------\n");
        System.out.format("%90s","|         TRAVEL DETAILS       |\n");
        System.out.format("%90s","--------------------------------\n");
        System.out.print("\033[0m");
        System.out.format("%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s\n\n",
                "Id","Driver name", "NIC Number", "Phone Number", "Date", "Time", "Vehical Number", "Vehical type",
                "Seats", "From", "To","Massage");
        for (int i = 0; i < data.size(); i++) {
            String doc = (String) data.elementAt(i);
            String[] datalist = doc.split(",");
            for (int j = 0; j < datalist.length; j++) {
                System.out.format("%-17s", datalist[j]);
            }
            System.out.println();
            
        }
        int navstate=nav.showNavigation(15);
    }

}
