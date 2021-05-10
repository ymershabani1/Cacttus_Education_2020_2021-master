package com.cacttuseducation2020_2021.models;

public class Person {

    private int image;
    private String name;
    private String surname;

    public Person(int image, String name, String surname){
        this.image = image;
        this.name = name;
        this.surname = surname;
    }

    public int getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

}
