package com.fireblend.uitest.entities;

/**
 * Created by Sergio on 8/20/2017.
 */

public class Contact {
    //Clase entidad para contener cada elemento de la lista, el cual representa un Contacto.
    public String name;
    public int age;
    public String email;
    public String phone;

    public Contact(String name, int age, String email, String phone){
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
}
