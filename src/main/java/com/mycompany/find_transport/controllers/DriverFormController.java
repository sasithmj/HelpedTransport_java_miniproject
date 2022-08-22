package com.mycompany.find_transport.controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DriverFormController extends PassengerController {
    private String vehicalnum;
    private String vehicaltype;
    private int id;
    
    File travelfile=new File("traveldata.txt");

    public DriverFormController(String name, String nic, int phone,int seats, String date,String time, String vehicalnum, String vehicaltype,
            String stfrom,
            String destination,
            String msg,int id) {
        super(name, nic, phone,seats,date,time, stfrom, destination, msg);
        this.vehicalnum = vehicalnum;
        this.vehicaltype = vehicaltype;
        this.id=id;
        setDriverdata();
    }
    public int setDriverdata(){
        int state=1;
        try {
            if (!(travelfile.createNewFile())) {
                try {
                    FileWriter writer = new FileWriter("traveldata.txt", true);
                    writer.write(
                        id+","+name + "," + nic + "," + phone + "," + date + "," + time+ "," + vehicalnum + "," + 
                        vehicaltype+ "," + seats+ "," + stfrom+ "," + destination+ "," + 
                        msg+"\n");
                    writer.close();

                } catch (IOException e) {
                    state=0;
                    System.out.println("error while adding user record.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return state;
    }

}
