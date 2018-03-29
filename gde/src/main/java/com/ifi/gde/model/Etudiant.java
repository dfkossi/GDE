/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.model;

import java.util.Date;
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
@Table(name = "Etudiants", catalog = "userapp")
public class Etudiant extends User {

    private Integer id;
    private Integer numMatricule;
    private String nomEtudiant;
    private String prenomEtudiant;
    private Date dateNaisEtudiant;
    private String nationaliteEtudiant;
    private String sexeEtudiant;

    public Etudiant() {
    }

    public Etudiant(Integer id, Integer numMatricule, String nomEtudiant, 
        String prenomEtudiant, Date dateNaisEtudiant, 
        String nationaliteEtudiant, String sexeEtudiant,
        String nomConnexion, String surname) {
        
        super(nomConnexion, surname);
        
        this.id = id;
        this.numMatricule = numMatricule;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.dateNaisEtudiant = dateNaisEtudiant;
        this.nationaliteEtudiant = nationaliteEtudiant;
        this.sexeEtudiant = sexeEtudiant;
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

    @Column(name = "NumMatricule", length = 30)
    public Integer getNumMatricule() {
        return this.numMatricule;
    }

    public void setNumMatricule(Integer numMatricule) {
        this.numMatricule = numMatricule;

    }
    
     @Column(name = "NomEtudiant", length = 20)
    public String getNomEtudiant() {
        return this.nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    @Column(name = "PrenomEtudiant", length = 20)
    public String getPrenomEtudiant() {
        return this.prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    @Column(name = "DateNaisEtudiant", length = 20)
    public Date getDateNaisEtudiant() {
        return this.dateNaisEtudiant;
    }

    public void setDateNaisEtudiant(Date dateNaisEtudiant) {
        this.dateNaisEtudiant = dateNaisEtudiant;
    }

    @Column(name = "NationaliteEtudiant", length = 30)
    public String getNationaliteEtudiant() {
        return this.nationaliteEtudiant;
    }

    public void setNationaliteEtudiant(String nationaliteEtudiant) {
        this.nationaliteEtudiant = nationaliteEtudiant;
    }

    @Column(name = "SexeEtudiant", length = 20)
    public String getSexeEtudiant() {
        return this.sexeEtudiant;
    }

    public void setSexeEtudiant(String sexeEtudiant) {
        this.sexeEtudiant = sexeEtudiant;
    }
}