package com.example.myhotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chaine_hoteliere")
public class Chain {

    @Id
    @Column(name = "chain_name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "noHotels")
    private int noHotels;

    public Chain(String name, String address, String email, String number, int noHotels) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = number;
        this.noHotels = noHotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return phone;
    }

    public void setNumber(String number) {
        this.phone = number;
    }

    public int getNoHotels() {
        return noHotels;
    }

    public void setNoHotels(int noHotels) {
        this.noHotels = noHotels;
    }

    @Override
    public String toString() {
        return "Chain{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", number='" + phone + '\'' +
                ", noHotels=" + noHotels +
                '}';
    }
}

