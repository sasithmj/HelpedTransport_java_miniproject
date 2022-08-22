package com.mycompany.find_transport.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import com.mycompany.find_transport.veiws.Userveiw;

public class UserContoller {

    File userfile = new File("traveldata.txt");
    Userveiw userveiw = new Userveiw();

    public Vector searchUser(String name, String nic, String userstate) {
        Vector<String> userdata = new Vector<String>();
        // String mydata[];
        try {
            if (!(userfile.createNewFile())) {
                File read = new File("Users.txt");
                Scanner myReader = new Scanner(read);
                int i = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String username = data.split(",")[0];
                    String usernic = data.split(",")[1];
                    String userlogstate = data.split(",")[3];

                    if (username.equals(name) && usernic.equals(nic) && userlogstate.equals(userstate)) {
                        userdata.addElement(data);
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

        userveiw.showUserDetails(userdata);

        return userdata;

    }

}
