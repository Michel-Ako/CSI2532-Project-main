package com.example.myhotel.model;

import javax.persistence.*;

@Entity
@Table(name = "chaine_hoteliere")
public class Chain {

    @Id
    @Column(name = "nom_chaine")
    private String nomChaine;

    @Column(name = "adresse_bureau")
    private String adresseBureau;

    @Column(name = "adresse_email")
    private String adresseEmail;

    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @Column(name = "nombre_hotels")
    private Integer nombreHotels;

    public String getNomChaine() {
        return nomChaine;
    }

    public void setNomChaine(String nomChaine) {
        this.nomChaine = nomChaine;
    }

    public String getAdresseBureau() {
        return adresseBureau;
    }

    public void setAdresseBureau(String adresseBureau) {
        this.adresseBureau = adresseBureau;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Integer getNombreHotels() {
        return nombreHotels;
    }

    public void setNombreHotels(Integer nombreHotels) {
        this.nombreHotels = nombreHotels;
    }

    // getters and setters
}
