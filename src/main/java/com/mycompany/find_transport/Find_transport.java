/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.find_transport;

import java.util.Scanner;

import com.mycompany.find_transport.controllers.Authcontroller;
import com.mycompany.find_transport.controllers.gotoXY;
import com.mycompany.find_transport.veiws.Auth;
import com.mycompany.find_transport.veiws.DriverForm;
import com.mycompany.find_transport.veiws.Home;
import com.mycompany.find_transport.veiws.PassengerForm;
import com.mycompany.find_transport.veiws.SearchUser;
import com.mycompany.find_transport.veiws.TravelDetailveiw;
import com.mycompany.find_transport.veiws.Updatetraveldata;

/**
 *
 * @author Pc
 */
public class Find_transport {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static Auth auth = new Auth();
    public static Home home = new Home();
    public static DriverForm dform = new DriverForm();
    public static PassengerForm pform=new PassengerForm();
    public static TravelDetailveiw travel=new TravelDetailveiw();
    public static SearchUser search=new SearchUser();
    public static Updatetraveldata update=new Updatetraveldata();
    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }


    public static void homeSwitching(int authstate,int logstate){
        switch (authstate) {
            case 1:
                clear();
                int homestate = home.showNavigation();
                switch (homestate) {
                    case 1:
                        clear();
                        pform.showPassengerForm();
                        //travel.showTravelDetails();
                        break;
                    case 2:
                        clear();
                        dform.showDriverForm();
                        break;
                    case 3:
                        clear();
                        search.search();
                    case 4:
                        clear();
                        update.updateData();
                }
                break;
            case 0:
                clear();
                logstate = auth.authScreen();
                break;

        }

    }
    static Authcontroller ac = new Authcontroller();

    public static void main(String[] args) {



        System.out.println("\033[H\033[2J");
        

        Scanner scn = new Scanner(System.in);
        int logstate = auth.authScreen();
        int authstate = 0;
        while (authstate == 0) {
            if (logstate == 1) {
                clear();
                authstate = auth.login();
            } else {
                clear();
                authstate = auth.register();
            }

        }
        homeSwitching(authstate,logstate);

        

        // if(state==0){
        // System.out.println("\033[H\033[2J");
        // System.out.flush();
        // }

        // login.data();
        // System.out.format("\033[H\033[2J Name: ", "sasith");
        // Scanner scn=new Scanner(System.in);
        // // if(scn.nextInt()==0){
        // // System.out.println("\033[H\033[2J");
        // // System.out.flush();
        // // }

    }
}
