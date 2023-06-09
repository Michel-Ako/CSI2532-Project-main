package com.example.myhotel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chambre")
public class Room {

    @Id
    @Column(name = "numero_chambre")
    private int numeroChambre;

    @Column(name = "type_chambre")
    private String typeChambre;

    @Column(name = "prix")
    private double prixParNuit;

    @Column(name = "disponibilite")
    private boolean disponibilite;

    @Column(name = "vue")
    private String vue;

    @Column(name = "capacite")
    private String capacite;

    @Column(name = "id_hotel")
    private String id_hotel;

    public String getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(String id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getVue() {
        return vue;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }


    // ManyToOne relationship with Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    // ManyToOne relationship with Hotel
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

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

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
