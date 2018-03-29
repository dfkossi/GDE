/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author david
 */
@Entity
@Table(name = "Promotions", catalog = "userapp")
public class Promotion {
    
    private Integer id;
    private String codePromotion;
    private Date dateOuverture;
    private Date dateFermeture;
    
    public Promotion() {
    }

    public Promotion(String codePromotion, Date dateOuverture, Date dateFermeture) {
        this.codePromotion = codePromotion;
        this.dateOuverture = dateOuverture;
        this.dateFermeture = dateFermeture;
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
    
    @Column(name = "CodePromotion", length = 30)
    public String getCodePromotion() {
        return this.codePromotion;
    }

    public void setCodePromotion(String codePromotion) {
        this.codePromotion = codePromotion;
    }

    @Column(name = "DateOuverture")
    public Date getDateOuverture() {
        return this.dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
    
    @Column(name = "DateFermeture")
    public Date getDateFermeture() {
        return this.dateFermeture;
    }

    public void setDateFermeture(Date dateFermeture) {
        this.dateFermeture = dateFermeture;
    }
}