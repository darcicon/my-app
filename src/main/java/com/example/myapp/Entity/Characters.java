package com.example.myapp.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Characters")
public class Characters implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "element")
    private String element;

    @Column(name = "weapon")
    private String WeaponName;

    @Column(name = "region")
    private String region;

    @Column(name = "src")
    private String src;

    public Characters(int id, String name, String element, String weaponName, String region, String src) {
        this.id = id;
        this.name = name;
        this.element = element;
        WeaponName = weaponName;
        this.region = region;
        this.src = src;
    }

    public Characters() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getWeaponName() {
        return WeaponName;
    }

    public void setWeaponName(String weaponName) {
        WeaponName = weaponName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
