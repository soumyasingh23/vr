package com.example.myvrapp;

import java.io.Serializable;

public class UserInformation implements Serializable {

    private String visitTemple;
    private String numberOfHoursSlept;
    private String appetite;
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserInformation() {
    }

    public String getVisitTemple() {
        return visitTemple;
    }

    public void setVisitTemple(String visitTemple) {
        this.visitTemple = visitTemple;
    }

    public String getNumberOfHoursSlept() {
        return numberOfHoursSlept;
    }

    public void setNumberOfHoursSlept(String numberOfHoursSlept) {
        this.numberOfHoursSlept = numberOfHoursSlept;
    }

    public String getAppetite() {
        return appetite;
    }

    public void setAppetite(String appetite) {
        this.appetite = appetite;
    }
}
