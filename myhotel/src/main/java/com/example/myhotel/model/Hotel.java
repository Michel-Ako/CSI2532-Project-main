package com.example.myhotel.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private int idHotel;

    @Column(name = "id_gestionnaire")
    private int idGestionnaire;

    @Column(name = "nom_hotel")
    private String nomHotel;

    @Column(name = "nombre_etoiles")
    private int nombreEtoiles;

    @Column(name = "adresse_hotel")
    private String adresseHotel;

    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @Column(name = "adresse_email")
    private String adresseEmail;

    @Column(name = "nombre_chambre")
    private int nombreChambre;

    // ManyToOne relationship with ChaineHoteliere
    @ManyToOne
    @JoinColumn(name = "nom_chaine")
    private Chain chaineHoteliere;

    // OneToMany relationship with Client
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Clients> clients;

    // OneToMany relationship with Chambre
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> chambres;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(int idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public int getNombreEtoiles() {
        return nombreEtoiles;
    }

    public void setNombreEtoiles(int nombreEtoiles) {
        this.nombreEtoiles = nombreEtoiles;
    }

    public String getAdresseHotel() {
        return adresseHotel;
    }

    public void setAdresseHotel(String adresseHotel) {
        this.adresseHotel = adresseHotel;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public int getNombreChambre() {
        return nombreChambre;
    }

    public void setNombreChambre(int nombreChambre) {
        this.nombreChambre = nombreChambre;
    }

    public Chain getChaineHoteliere() {
        return chaineHoteliere;
    }

    public void setChaineHoteliere(Chain chaineHoteliere) {
        this.chaineHoteliere = chaineHoteliere;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    public List<Room> getChambres() {
        return chambres;
    }

    public void setChambres(List<Room> chambres) {
        this.chambres = chambres;
    }
}