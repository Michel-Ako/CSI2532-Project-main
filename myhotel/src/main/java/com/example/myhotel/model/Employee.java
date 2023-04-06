package com.example.myhotel.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private int employee_ID;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "ssn", nullable = false)
    private String ssn;

    @Column(name = "post", nullable = false)
    private String post;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")
    @NotBlank(message = "Hotel ID required")
    private Hotel hotel;

    public Employee(Long id, String name, String address, String ssn, String post, Hotel hotel) {
        this.employee_ID = Math.toIntExact(id);
        this.name = name;
        this.address = address;
        this.ssn = ssn;
        this.post = post;
        this.hotel = hotel;
    }

    public Employee() {
    }

    public Long getId() {
        return Long.valueOf(employee_ID);
    }

    public void setId(Long id) {
        this.employee_ID = Math.toIntExact(id);
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employee_ID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", ssn='" + ssn + '\'' +
                ", post='" + post + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
