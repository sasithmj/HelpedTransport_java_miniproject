package com.mycompany.find_transport.controllers;

public abstract class Authentication {
    abstract int userLogin(int phone,String psw);
    abstract int userRegister(String name, String NIC, int phone, String register, String psw);
         
    
}
