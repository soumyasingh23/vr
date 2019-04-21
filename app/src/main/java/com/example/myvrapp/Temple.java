package com.example.myvrapp;

import java.util.Comparator;

public class Temple {

    private String name;
    private String city;
    private String Image;
    private int dist;

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }


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

    public Temple(String name, String city, String image, int dist) {
        this.name = name;
        this.city = city;
        this.Image = image;
        this.dist = dist;
    }
}

class SortByDist implements Comparator<Temple>
{

    @Override
    public int compare(Temple o1, Temple o2) {
        return o2.getDist() - o1.getDist();
    }
}
