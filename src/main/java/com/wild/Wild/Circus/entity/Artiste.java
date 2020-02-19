package com.wild.Wild.Circus.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2,max=255)
    private String name;
    private String presentation;

    @ManyToMany(mappedBy="artistes")
    private Set<Spectacle> spectacles;

    //Constructor
    public Artiste() {
        spectacles = new HashSet();
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

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Set<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setSpectacles(Set<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }
}
