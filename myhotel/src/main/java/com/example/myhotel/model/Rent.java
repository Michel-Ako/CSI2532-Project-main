package com.example.myhotel.model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.example.myhotel.model.Clients;
@Entity
@Table(name = "Rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_ID", nullable = false)
    private Long rent_ID;

    @Column(name = "rentdate", nullable = false)
    private LocalDate rentdate;

    @Column(name = "startrent", nullable = false)
    private LocalDate startrent;

    @Column(name = "enddate", nullable = false)
    private LocalDate enddate;

    @Column(name = "noRoom", nullable = false)
    private int noRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_ID", referencedColumnName = "client_ID")
    @NotBlank(message = "Client ID required")
    private Clients ID_customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noArchive", referencedColumnName = "noArchive")
    @NotBlank(message = "Archives number required")
    private Archives noArchives;

    public Rent() {
    }

    public Rent(LocalDate rentdate, LocalDate startrent, LocalDate enddate, int noRoom, Clients ID_customer, Archives noArchives) {
        this.rentdate = rentdate;
        this.startrent = startrent;
        this.enddate = enddate;
        this.noRoom = noRoom;
        this.ID_customer = ID_customer;
        this.noArchives = noArchives;
    }

    public Long getID() {
        return rent_ID;
    }

    public void setID(Long ID) {
        this.rent_ID = ID;
    }

    public LocalDate getRentdate() {
        return rentdate;
    }

    public void setRentdate(LocalDate rentdate) {
        this.rentdate = rentdate;
    }

    public LocalDate getStartrent() {
        return startrent;
    }

    public void setStartrent(LocalDate startrent) {
        this.startrent = startrent;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public int getNoRoom() {
        return noRoom;
    }

    public void setNoRoom(int noRoom) {
        this.noRoom = noRoom;
    }

    public Clients getCustomer() {
        return ID_customer;
    }

    public void setCustomer(Clients ID_customer) {
        this.ID_customer = ID_customer;
    }

    public Archives getNoArchives() {
        return noArchives;
    }

    public void setNoArchives(Archives noArchives) {
        this.noArchives = noArchives;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "ID='" + rent_ID + '\'' +
                ", rentdate=" + rentdate +
                ", startrent=" + startrent +
                ", enddate=" + enddate +
                ", noRoom='" + noRoom + '\'' +
                ", ID_customer=" + ID_customer +
                ", noArchives=" + noArchives +
                '}';
    }
}

