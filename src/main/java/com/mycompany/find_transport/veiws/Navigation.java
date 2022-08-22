package com.mycompany.find_transport.veiws;

import java.util.Scanner;

import com.mycompany.find_transport.Find_transport;
import com.mycompany.find_transport.controllers.gotoXY;

public class Navigation extends Find_transport {
    //\033[1;34m
    gotoXY gotoXY=new gotoXY();
    public int showNavigation(int row){
        Scanner scn=new Scanner(System.in);
        gotoXY.gotoXYCoords(row, 0);
        System.out.print("\033[1;34m");
        System.out.print("-------------\n");
        System.out.print("| 1.Back    |\n");
        System.out.print("-------------\n");
        System.out.print("\033[0m");
        gotoXY.gotoXYCoords(row+1, 10);
        int state=scn.nextInt();
        homeSwitching(state, 1);
        return state;
    }


    
}
