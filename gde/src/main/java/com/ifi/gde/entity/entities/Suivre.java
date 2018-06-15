/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author dfkossi
 */
@Entity
@Table(name = "notes")
public class Suivre implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected SuivrePK suivrePK;
    
    @Column(name = "NoteObtenue", length = 20)
    private Double noteObtenue;

    public Suivre() {
    }

    public SuivrePK getSuivrePK() {
        return suivrePK;
    }

    public void setSuivrePK(SuivrePK suivrePK) {
        this.suivrePK = suivrePK;
    }

    public Double getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(Double noteObtenue) {
        this.noteObtenue = noteObtenue;
    }

    @Override
    public String toString() {
        return "Suivre{" + "suivrePK=" + suivrePK + ", noteObtenue=" + noteObtenue + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.suivrePK);
        hash = 11 * hash + Objects.hashCode(this.noteObtenue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Suivre other = (Suivre) obj;
        return Objects.equals(this.suivrePK, other.suivrePK);
    }

    
}