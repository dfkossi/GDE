/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name = "filieres", catalog = "userapp")
public class Filiere {

    private Integer id;
    private String codeFiliere;
    private String libeleFiliere;

    public Filiere() {
    }

    public Filiere(String codeFiliere, String libeleFiliere) {
        this.codeFiliere = codeFiliere;
        this.libeleFiliere = libeleFiliere;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "CodeFiliere", length = 20)
    public String getCodeFiliere() {
        return this.codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;

    }

    @Column(name = "LibeleFiliere", length = 20)
    public String getLibeleFiliere() {
        return this.libeleFiliere;
    }

    public void setLibeleFiliere(String libeleFiliere) {
        this.libeleFiliere = libeleFiliere;
    }
}