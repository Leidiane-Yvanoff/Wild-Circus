package com.wild.Wild.Circus.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Spectacle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int prix;
    private String ville;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int places;
    @Column(columnDefinition = "String default 'https://cdn.pixabay.com/photo/2015/10/17/23/06/circus-993622_1280.jpg'" )
    private String photoUrl;

    @ManyToMany
    private Set<Artiste> artistes;

    // Constructor
    public Spectacle() {
        artistes = new HashSet();
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Set<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(Set<Artiste> artistes) {
        this.artistes = artistes;
    }

}
