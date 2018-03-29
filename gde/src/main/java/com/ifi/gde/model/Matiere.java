/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.model;

import javax.annotation.Generated;
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
@Table(name = "Matieres", catalog = "userapp")
public class Matiere {
    
    private Integer id;
    private String codeMatiere;
    private String intituleMatiere;
    private Integer nbreHeureMatiere;
    private Integer nombreECTS;
   
    public Matiere() {
    }

    public Matiere(String codeMatiere, String intituleMatiere, Integer nbreHeureMatiere, Integer nombreECTS) {
        this.codeMatiere = codeMatiere;
        this.intituleMatiere = intituleMatiere;
        this.nbreHeureMatiere = nbreHeureMatiere;
        this.nombreECTS = nombreECTS;
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
    
    @Column(name = "CodeMatiere", length = 30)
    public String getCodeMatiere() {
        return this.codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    @Column(name = "IntituleMatiere", length = 20)
    public String getIntituleMatiere() {
        return this.intituleMatiere;
    }

    public void setIntituleMatiere(String intituleMatiere) {
        this.intituleMatiere = intituleMatiere;

    }

    @Column(name = "NbreHeureMatiere", length = 20)
    public Integer getNbreHeureMatiere() {
        return this.nbreHeureMatiere;
    }

    public void setNbreHeureMatiere(Integer nbreHeureMatiere) {
        this.nbreHeureMatiere = nbreHeureMatiere;
    }
    
    @Column(name = "NombreECTS", length = 20)
    public Integer getNombreECTS() {
        return this.nombreECTS;
    }

    public void setNombreECTS(Integer nombreECTS) {
        this.nombreECTS = nombreECTS;
    }
}