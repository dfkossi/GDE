/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author dfkossi
 */
@Entity
@Table(name = "notes")
public class Suivre implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="suivre_id",nullable=false)
    private Integer suivreId;
    
    @Column(name = "note_obtenue", length = 20)
    private Double noteObtenue;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "matiere_note") 
    @JoinColumn(name="matiere_id", referencedColumnName = "matiere_id")
    private Matiere matiereNote;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_note") 
    @JoinColumn(name="etudiant_id", referencedColumnName = "etudiant_id")
    private Etudiant etudiantNote;

    
    public Suivre() {
//        this.matiereNote = new Matiere();
//        this.etudiantNote = new Etudiant();
    }

    public Integer getSuivreId() {
        return suivreId;
    }

    public void setSuivreId(Integer suivreId) {
        this.suivreId = suivreId;
    }

    
    public Double getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(Double noteObtenue) {
        this.noteObtenue = noteObtenue;
    }

    public Matiere getMatiereNote() {
        return matiereNote;
    }

    public void setMatiereNote(Matiere matiereNote) {
        this.matiereNote = matiereNote;
    }

    public Etudiant getEtudiantNote() {
        return etudiantNote;
    }

    public void setEtudiantNote(Etudiant etudiantNote) {
        this.etudiantNote = etudiantNote;
    }

    @Override
    public String toString() {
        return "Suivre{" + "suivreId=" + suivreId + ", noteObtenue=" +
                noteObtenue + ", matiereNote=" + matiereNote +
                ", etudiantNote=" + etudiantNote + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.suivreId;
        hash = 53 * hash + Objects.hashCode(this.noteObtenue);
        hash = 53 * hash + Objects.hashCode(this.matiereNote);
        hash = 53 * hash + Objects.hashCode(this.etudiantNote);
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
        if (this.suivreId != other.suivreId) {
            return false;
        }
        if (!Objects.equals(this.matiereNote, other.matiereNote)) {
            return false;
        }
        return Objects.equals(this.etudiantNote, other.etudiantNote);
    }
    
    
    
//
//    private static final long serialVersionUID = 1L;
//    
//    @EmbeddedId
//    protected SuivrePK suivrePK;
//    
//    @Column(name = "note_obtenue", length = 20)
//    private Double noteObtenue;
//
//    public Suivre() {
////        this.suivrePK = new SuivrePK();
//    }
//
//    public Suivre(SuivrePK suivrePK) {
//        this.suivrePK = suivrePK;
//    }
//    
//
//    public SuivrePK getSuivrePK() {
//        return suivrePK;
//    }
//
//    public void setSuivrePK(SuivrePK suivrePK) {
//        this.suivrePK = suivrePK;
//    }
//
//    public Double getNoteObtenue() {
//        return noteObtenue;
//    }
//
//    public void setNoteObtenue(Double noteObtenue) {
//        this.noteObtenue = noteObtenue;
//    }
//
//    @Override
//    public String toString() {
//        return "Suivre{" + "suivrePK=" + suivrePK + ", noteObtenue=" + noteObtenue + '}';
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 11 * hash + Objects.hashCode(this.suivrePK);
//        hash = 11 * hash + Objects.hashCode(this.noteObtenue);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Suivre other = (Suivre) obj;
//        return Objects.equals(this.suivrePK, other.suivrePK);
//    }
//
//    

}