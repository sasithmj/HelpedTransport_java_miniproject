/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.find_transport.veiws;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.mycompany.find_transport.controllers.Authcontroller;
import com.mycompany.find_transport.controllers.gotoXY;

/**
 *
 * @author Pc
 */
public class Auth {
    int column = 105;
    gotoXY gotoXY = new gotoXY();
    Authcontroller authnew = new Authcontroller();
    Scanner scn = new Scanner(System.in);

    public int authScreen() {
        System.out.println("\033[1;34m");
        System.out.format("%90s", "--------------------------------\n");
        System.out.format("%90s", "|         TRAVELER             |\n");
        System.out.format("%90s", "--------------------------------\n");
        System.out.println("\033[0m");

        System.out.format("%70s", "1) Login \n");
        System.out.format("%74s", "2) Register \n\n");
        System.out.format("%82s", "*** Start Now(1 OR 2): ");
        int logstate = scn.nextInt();
        scn.nextLine();

        return logstate;
    }

    public int login() { // Method for login veiw
        int state=0;
        System.out.print("\033[1;34m");
        System.out.format("%90s", "--------------------------------\n");
        System.out.format("%90s", "|            LOGIN             |\n");
        System.out.format("%90s", "--------------------------------\n");
        System.out.print("\033[0m");

        try {
            System.out.format("%73s", "Phone Number: \n");
            System.out.format("%69s", "Password: \n");
            gotoXY.gotoXYCoords(5, 75);
            int phonenumber = scn.nextInt();
            gotoXY.gotoXYCoords(6, 75);
            String psw = scn.next();

            state = authnew.userLogin(phonenumber, psw);

        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        if (state == 0) {
            System.out.print("\033[1;31m");
            System.out.format("%90s", "--------------------------------\n");
            System.out.format("%90s", "|Username or password incorrect|\n");
            System.out.format("%90s", "--------------------------------\n");
            System.out.print("\033[0m");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return state;
    }

    public int register() {
        System.out.print("\033[1;34m");
        System.out.format("%103s", "--------------------------------------------\n");
        System.out.format("%103s", "|                  Register                |\n");
        System.out.format("%103s", "--------------------------------------------\n");
        System.out.print("\033[0m");

        System.out.format("%70s", "Full Name: \n");
        System.out.format("%71s", "NIC Number: \n");
        System.out.format("%73s", "Phone Number: \n");
        System.out.format("%98s", "Wish to register as(Driver/Passenger): \n");
        System.out.format("%69s", "Password: \n");
        System.out.format("%77s", "Confirm Password: \n");
        gotoXY.gotoXYCoords(5, column);
        System.out.flush();
        String name = scn.nextLine();

        gotoXY.gotoXYCoords(6, column);
        String NIC = scn.next();

        gotoXY.gotoXYCoords(7, column);
        int phone = scn.nextInt();

        gotoXY.gotoXYCoords(8, column);
        String register = scn.next();

        gotoXY.gotoXYCoords(9, column);
        String psw = scn.next();

        gotoXY.gotoXYCoords(10, column);
        String confirmpsw;

        while (!(psw.equals(scn.next()))) {
            gotoXY.gotoXYCoords(11, 0);
            System.out.print("--------------------------------\n");
            System.out.print("|      Password Incorrect      |\n");
            System.out.print("--------------------------------\n");
            gotoXY.gotoXYCoords(10, column);
        }

        authnew.userRegister(name, NIC, phone, register, psw);
        return 1;
    }
}
