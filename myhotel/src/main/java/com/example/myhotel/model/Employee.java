package com.example.myhotel.model;

import javax.persistence.*;

@Entity
@Table(name = "employe")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_employe;

    @Column(name = "nom_complet")
    private String nomComplet;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "nas")
    private int nas;

    @Column(name = "poste")
    private String poste;

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getNom_complet() {
        return nomComplet;
    }

    public void setNom_complet(String nomComplet) {
        this.nomComplet = nomComplet;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
