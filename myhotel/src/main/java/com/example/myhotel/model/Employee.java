package com.example.myhotel.model;

import javax.persistence.*;

@Entity
@Table(name = "employe")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employe")
    private Integer idEmploye;

    @Column(name = "nom_complet")
    private String nomComplet;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "nas")
    private Integer nas;

    @Column(name = "poste")
    private String poste;

    public Integer getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Integer idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getNas() {
        return nas;
    }

    public void setNas(Integer nas) {
        this.nas = nas;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

}
