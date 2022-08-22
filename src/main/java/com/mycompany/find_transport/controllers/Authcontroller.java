package com.mycompany.find_transport.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.mycompany.find_transport.Models.User;

public class Authcontroller extends Authentication{
    File usersFile = new File("Users.txt");
    private User user;

    public User getUser(){
        return user;
    }

    @Override
    public int userLogin(int phone,String psw){
        int state=1;
        try {
            if (!(usersFile.createNewFile())) {
                File read=new File("Users.txt");
                Scanner myReader = new Scanner(read);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String phonenum=data.split(",")[2];
                    String pass=data.split(",")[5];
                    int phoneint=Integer.parseInt(phonenum);
                    if(phoneint==phone && pass.equals(psw)){  
                        state=1;
                        user=new User(data.split(",")[0],data.split(",")[1],phone);
                        break;
                    }else{
                        state=0;
                    }
                  }
                  myReader.close();
            }else{
                state=0;
            }
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
            state=0;
        }
        return state;
    }
    
    @Override
    public int userRegister(String name, String NIC, int phone, String register, String psw) {
        int state=1;
        try {
            if (!(usersFile.createNewFile())) {
                try {
                    FileWriter writer = new FileWriter("Users.txt", true);
                    writer.write(name + "," + NIC + "," + phone + "," + register + ","+ "0"+"," + psw + "\n");
                    writer.close();
                    user=new User(name,NIC,phone);

                } catch (IOException e) {
                    state=0;
                    System.out.println("error while adding user record.");
                }

            }
        } catch (IOException e) {
            state=0;
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return state;

    }
    

}
