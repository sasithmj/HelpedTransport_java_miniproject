package com.mycompany.find_transport.controllers;

public class gotoXY {
    char escCode=033; 
    public void gotoXYCoords(int row,int col){
        System.out.print(String.format("%c[%d;%df", escCode, row, col));
    }
    
    
}
