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
@Table(name = "Professeurs", catalog = "userapp")
public class Professeur extends User {

    private Integer id;
    private Integer codeProfesseur;
    private String nomProfesseur;
    private String prenomProfesseur;
    private String sexeProfesseur;
    private String specialiteProfesseur;
    
    public Professeur() {
    }

    public Professeur(Integer id, Integer codeProfesseur, String nomProfesseur, 
        String prenomProfesseur, String sexeProfesseur, String specialiteProfesseur,
        String nomConnexion, String surname) {
        
        super(nomConnexion, surname);
        
        this.id = id;
        this.codeProfesseur = codeProfesseur;
        this.nomProfesseur = nomProfesseur;
        this.prenomProfesseur = prenomProfesseur;
        this.sexeProfesseur = sexeProfesseur;
        this.specialiteProfesseur = specialiteProfesseur;
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

    @Column(name = "CodeProfesseur", length = 30)
    public Integer getCodeProfesseur() {
        return this.codeProfesseur;
    }

    public void setCodeProfesseur(Integer codeProfesseur) {
        this.codeProfesseur = codeProfesseur;

    }

    @Column(name = "NomEtudiant", length = 20)
    public String getNomProfesseur() {
        return this.nomProfesseur;
    }

    public void setNomProfesseur(String nomProfesseur) {
        this.nomProfesseur = nomProfesseur;
    }
    
    @Column(name = "PrenomEtudiant", length = 20)
    public String getPrenomProfesseur() {
        return this.prenomProfesseur;
    }

    public void setPrenomProfesseur(String prenomProfesseur) {
        this.prenomProfesseur = prenomProfesseur;
    }
    
    @Column(name = "SexeProfesseur", length = 20)
    public String getSexeProfesseur() {
        return this.sexeProfesseur;
    }

    public void setSexeProfesseur(String sexeProfesseur) {
        this.sexeProfesseur = sexeProfesseur;
    }

    @Column(name = "SpecialiteProfesseur", length = 30)
    public String getSpecialiteProfesseur() {
        return this.specialiteProfesseur;
    }

    public void setSpecialiteProfesseur(String specialiteProfesseur) {
        this.specialiteProfesseur = specialiteProfesseur;
    }
}