/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author dfkossi
 */
@Entity
@Table(name="filiere")
public class Filiere implements Serializable{
    
    private static final long serialVersionUID =  1L;  
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="filiere_id",nullable=false)
    private Integer filiereId;
    
    @Column(name = "filiere_code", length = 20)
    private String filiereCode;
    
    @Column(name = "filiere_libele", length = 60)
    private String filiereLibelle;

    @OneToMany(mappedBy = "etudiantFiliere", fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_filiere")        
    private List<Etudiant> etudiantListFil;
    
    public Filiere() {
    }

    public Integer getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Integer filiereId) {
        this.filiereId = filiereId;
    }

    public String getFiliereCode() {
        return filiereCode;
    }

    public void setFiliereCode(String filiereCode) {
        this.filiereCode = filiereCode;
    }

    public String getFiliereLibelle() {
        return filiereLibelle;
    }

    public void setFiliereLibelle(String filiereLibelle) {
        this.filiereLibelle = filiereLibelle;
    }

    public List<Etudiant> getEtudiantListFil() {
        return etudiantListFil;
    }

    public void setEtudiantListFil(List<Etudiant> etudiantListFil) {
        this.etudiantListFil = etudiantListFil;
    }

    @Override
    public String toString() {
        return "Filiere{" + "filiereId=" + filiereId + 
                ", filiereCode=" + filiereCode + ", filiereLibelle=" 
                + filiereLibelle + '}';
    }

    
//    @Override
//    public String toString() {
//        return "Filiere{" + "filiereId=" + filiereId + ", filiereCode=" +
//                filiereCode + ", filiereLibelle=" + filiereLibelle +
//                ", etudiantListFil=" + etudiantListFil + '}';
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.filiereId);
        hash = 89 * hash + Objects.hashCode(this.filiereCode);
        hash = 89 * hash + Objects.hashCode(this.filiereLibelle);
        hash = 89 * hash + Objects.hashCode(this.etudiantListFil);
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
        final Filiere other = (Filiere) obj;
        return true;
    }

    
    
}
