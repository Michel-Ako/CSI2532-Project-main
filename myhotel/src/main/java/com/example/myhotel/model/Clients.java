package com.example.myhotel.model;

import java.time.LocalDate;
import com.example.myhotel.model.Employee;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "client")
public class Clients {

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employee employe;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_ID", nullable = false)
    private Long client_ID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "SSN", nullable = false)
    private int SSN;

    @Column(name = "payment", nullable = false)
    private String payment;

    @Column(name = "checkin", nullable = false)
    private LocalDate checkin;

    @ManyToOne(targetEntity = Hotel.class)
    @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")
    @NotBlank(message = "Hotel ID required")
    private Hotel ID_Hotel;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_ID", referencedColumnName = "employee_ID")
    @NotBlank(message = "Employee ID required")
    private Employee ID_employee;

    public Clients(Long ID, String name, String address, int SSN, String payment, LocalDate checkin, Hotel ID_Hotel, Employee ID_employee) {
        this.client_ID = ID;
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.payment = payment;
        this.checkin = checkin;
        this.ID_Hotel = ID_Hotel;
        this.ID_employee = ID_employee;
    }

    public Clients() {
    }

    public Long getID() {
        return client_ID;
    }

    public void setID(Long ID) {
        this.client_ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public Hotel getHotel() {
        return ID_Hotel;
    }

    public void setHotel(Hotel ID_Hotel) {
        this.ID_Hotel = ID_Hotel;
    }

    public Employee getID_employee() {
        return ID_employee;
    }

    public void setID_employee(Employee ID_employee) {
        this.ID_employee = ID_employee;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Clients{" +
                "ID=" + client_ID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SSN=" + SSN +
                ", payment='" + payment + '\'' +
                ", checkin=" + checkin +
                ", ID_Hotel=" + ID_Hotel +
                ", ID_employee=" + ID_employee +
                '}';
    }
}


