package com.example.myhotel.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "client")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "nom_complet")
    private String nom_complet;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "nas")
    private int nas;

    @Column(name = "etat_paiement")
    private String etatPaiement;

    @Column(name = "date_enregistrement")
    private Timestamp dateEnregistrement;

    // ManyToOne relationship with Employe
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employee employe;

    // ManyToOne relationship with Hotel
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    // OneToMany relationship with Chambre
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
            private List<Room> chambres;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getnom_complet() {
        return nom_complet;
    }

    public void setnom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNas() {
        return nas;
    }

    public void setNas(int nas) {
        this.nas = nas;
    }

    public String getEtatPaiement() {
        return etatPaiement;
    }

    public void setEtatPaiement(String etatPaiement) {
        this.etatPaiement = etatPaiement;
    }

    public Timestamp getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Timestamp dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
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

    public List<Room> getChambres() {
        return chambres;
    }

    public void setChambres(List<Room> chambres) {
        this.chambres = chambres;
    }
}