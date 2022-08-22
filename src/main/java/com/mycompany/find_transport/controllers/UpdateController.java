package com.mycompany.find_transport.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import com.mycompany.find_transport.veiws.TravelDetailveiw;

public class UpdateController extends PassengerController{
    File travelfile = new File("traveldata.txt");

    public Vector<String> searchVehical(int phone) {
        TravelDetailveiw tdveiw = new TravelDetailveiw();
        Vector<String> traveldata = new Vector<String>();
        // String mydata[];

        try {
            if (!(travelfile.createNewFile())) {
                File read = new File("traveldata.txt");
                Scanner myReader = new Scanner(read);
                int i = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String ph = data.split(",")[3];
                    String fdestination = data.split(",")[10];
                    // String pass=data.split(",")[4];
                    int phint = Integer.parseInt(ph);
                    if (phint == phone) {
                        traveldata.addElement(data);
                        // state=1;
                        // user=new User(data.split(",")[0],data.split(",")[1],phone);

                    } else {
                        // state=0;
                    }
                }
                myReader.close();
            } else {
                // state=0;
            }
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
            // state=0;
        }
        // System.out.println(traveldata);
        // if (traveldata.size() != 0) {
        //     tdveiw.showTravelDetails(traveldata);
        // }

        return traveldata;
    }

    public void deleteFile(int id) {
        File dfile = new File("dfile.txt");
        File travelfile = new File("traveldata.txt");

        try {
            dfile.createNewFile();
            FileWriter writer = new FileWriter("dfile.txt", true);
            Scanner myReader = new Scanner(travelfile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] datasplite = data.split(",");
                int intid = Integer.parseInt(datasplite[0]);
                if (intid != id) {
                    writer.write(data+"\n");
                    
                }
            }
            writer.close();
            myReader.close();
            travelfile.delete();
            boolean filename=dfile.renameTo(travelfile);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       


    }

}
