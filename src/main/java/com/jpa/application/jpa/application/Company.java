package com.jpa.application.jpa.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String name;
    int duration;    //IN MONTHS
    String profile;
    int stipend;    //CAN BE 0
    boolean workFromHome;

    public Company() {
    }

    public Company(String name, int duration, String profile, int stipend, boolean workFromHome) {
        this.name = name;
        this.duration = duration;
        this.profile = profile;
        this.stipend = stipend;
        this.workFromHome = workFromHome;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getDuration() {
        return duration;
    }


    public String getProfile() {
        return profile;
    }


    public int getStipend() {
        return stipend;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWorkFromHome() {
        return workFromHome;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", profile='" + profile + '\'' +
                ", stipend=" + stipend +
                ", workFromHome=" + workFromHome +
                '}';
    }

}
