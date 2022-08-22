package com.mycompany.find_transport.controllers;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import com.mycompany.find_transport.veiws.TravelDetailveiw;

public class PassengerController {
    
    String name;
    String nic;
    int phone;
    int seats;
    String date;
    String time;
    String stfrom;
    String destination;
    String msg;

    File travelfile=new File("traveldata.txt");

    public PassengerController(){

    }
    
    public PassengerController(String name,String nic,int phone,int seats,String date,String time,String stfrom,String destination,String msg){
        this.name=name;
        this.nic=nic;
        this.phone=phone;
        this.date=date;
        this.time=time;
        this.stfrom=stfrom;
        this.destination=destination;
        this.msg=msg;
        this.seats=seats;
        searchVehical(phone);
    }

    public Vector searchVehical(int phone){
        
        TravelDetailveiw tdveiw=new TravelDetailveiw();
        Vector <String> traveldata=new Vector<String>();
        // String mydata[];

        try {
            if (!(travelfile.createNewFile())) {
                File read=new File("traveldata.txt");
                Scanner myReader = new Scanner(read);
                int i=0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String seatnum=data.split(",")[8];
                    String fdestination=data.split(",")[10];
                    // String pass=data.split(",")[4];
                    int seatint=Integer.parseInt(seatnum);
                    if(seatint==seats && fdestination.equals(destination)){  
                        traveldata.addElement(data);
                        //state=1;
                        //user=new User(data.split(",")[0],data.split(",")[1],phone);
                        
                    }else{
                        //state=0;
                    }
                  }
                  myReader.close();
            }else{
                //state=0;
            }
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
           // state=0;
        }
        //System.out.println(traveldata);
        if(traveldata.size()!=0){
            tdveiw.showTravelDetails(traveldata);
        }
        
        return traveldata;
    }

    
}
