package com.example.myhotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "chambre")
public class Room {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employee employe;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @Id
    @Column(name = "roomNumber", nullable = false)
    private int roomNumber;

    @Column(name = "RoomType", nullable = false)
    private String roomType;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "capacity", nullable = false)
    private String capacity;

    @Column(name = "view", nullable = false)
    private String view;

    @Column(name = "extent", nullable = false)
    private boolean extent;

    @Column(name = "damage", nullable = false)
    private String damage;

    @Column(name = "amenities", nullable = false)
    private String amenities;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    @Column(name = "status", nullable = false)
    private String status;

    public Room() {
    }

    public Room(int roomNumber, String roomType, double price, String capacity, String view, boolean extent, String damage, String amenities, boolean availability, String status, Hotel hotel, Clients client, Employee employe) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.capacity = capacity;
        this.view = view;
        this.extent = extent;
        this.damage = damage;
        this.amenities = amenities;
        this.availability = availability;
        this.status = status;
        this.hotel = hotel;
        this.client = client;
        this.employe = employe;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public boolean isExtent() {
        return extent;
    }

    public void setExtent(boolean extent) {
        this.extent = extent;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Clients getClientID() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Employee getEmploye() {
        return employe;
    }

    public void setEmploye(Employee employe) {
        this.employe = employe;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }



}
