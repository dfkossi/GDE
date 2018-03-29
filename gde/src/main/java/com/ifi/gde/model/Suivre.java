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
@Table(name = "Notes", catalog = "userapp")
public class Suivre {

    private Integer id;
    private Integer numMatricule;
    private String codeMatiere;
    private Double noteObtenue;

    public Suivre() {
    }

    public Suivre(Integer numMatricule, String codeMatiere, Double noteObtenue) {
        this.numMatricule = numMatricule;
        this.codeMatiere = codeMatiere;
        this.noteObtenue = noteObtenue;
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

    @Column(name = "CodeMatiere", length = 20)
    public String getCodeMatiere() {
        return this.codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }
    
    @Column(name = "NoteObtenue", length = 20)
    public Double getNoteObtenue() {
        return this.noteObtenue;
    }

    public void setNoteObtenue(Double noteObtenue) {
        this.noteObtenue = noteObtenue;
    }
}