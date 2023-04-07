package com.example.myhotel.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "chambre")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomNumber", nullable = false)
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "id_gestionnaire")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

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

    public Room(int roomNumber, String roomType, double price, String capacity, String view, boolean extent, String damage, String amenities, boolean availability, String status, Hotel hotel, Clients client) {
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
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }
}