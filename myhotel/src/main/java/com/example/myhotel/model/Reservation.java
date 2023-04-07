package com.example.myhotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationID;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    @Column(name = "archive_number")
    private int archiveNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Clients client;

    public Reservation() {
    }

    public Reservation(LocalDate startDate, LocalDate endDate, int roomNumber, Clients client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.client = client;
    }

    public Long getReservationID() {
        return reservationID;
    }

    public void setReservationID(Long reservationID) {
        this.reservationID = reservationID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getArchiveNumber() {
        return archiveNumber;
    }

    public void setArchiveNumber(int archiveNumber) {
        this.archiveNumber = archiveNumber;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", roomNumber=" + roomNumber +
                ", archiveNumber=" + archiveNumber +
                ", client=" + client +
                '}';
    }
}
