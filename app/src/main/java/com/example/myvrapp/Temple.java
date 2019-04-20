package com.example.myvrapp;

public class Temple {

    private String name;
    private String city;
    private String Image;

    public String getName() {
        return name;
    }

    public Temple() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }

    public Temple(String name, String city, String image) {
        this.name = name;
        this.city = city;
        this.Image = image;
    }
}
