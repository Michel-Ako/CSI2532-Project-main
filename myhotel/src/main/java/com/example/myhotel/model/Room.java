package com.example.myhotel.model;

public class Room {
    private int numeroChambre;
    private String typeChambre;
    private double prixParNuit;
    private Hotel hotel;

    public Room(int numeroChambre, String typeChambre, double prixParNuit, Hotel hotel) {
        this.numeroChambre = numeroChambre;
        this.typeChambre = typeChambre;
        this.prixParNuit = prixParNuit;
        this.hotel = hotel;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
