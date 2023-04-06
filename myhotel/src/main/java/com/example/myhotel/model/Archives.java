package com.example.myhotel.model;
import javax.persistence.*;

@Entity
@Table(name = "archive")
public class Archives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noArchive", nullable = false)
    private int noArchive;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "archives_ID", nullable = false)
    private int archives_ID;

    public Archives() {
    }

    public Archives(int noArchive, String type, int ID) {
        this.noArchive = noArchive;
        this.type = type;
        this.archives_ID = ID;
    }

    public int getNoArchive() {
        return noArchive;
    }

    public void setNoArchive(int noArchive) {
        this.noArchive = noArchive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return archives_ID;
    }

    public void setID(int ID) {
        this.archives_ID = ID;
    }

    @Override
    public String toString() {
        return "Archives{" +
                "noArchive='" + noArchive + '\'' +
                ", type='" + type + '\'' +
                ", ID='" + archives_ID + '\'' +
                '}';
    }
}

