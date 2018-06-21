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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author dfkossi
 */
@Entity
@Table(name="sexe")
public class Sexe implements Serializable{
    
    
    private static final long serialVersionUID =  1L;   
    
    @Id
    @GeneratedValue
    @Column(name="sexe_id",nullable=false)
    private Integer sexeId;
    @Column(name="sexe_libelle", unique=true, nullable=false, length=9)
    private String sexeLibelle;

    @OneToMany(mappedBy = "etudiantSexe", fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_sexe")        
    private List<Etudiant> etudiantList;

    public Sexe() {
    }

    public Integer getSexeId() {
        return sexeId;
    }

    public void setSexeId(Integer sexeId) {
        this.sexeId = sexeId;
    }

    public String getSexeLibelle() {
        return sexeLibelle;
    }

    public void setSexeLibelle(String sexeLibelle) {
        this.sexeLibelle = sexeLibelle;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    @Override
    public String toString() {
        return "Sexe{" + "sexeId=" + sexeId + ", sexeLibelle=" + sexeLibelle + '}';
    }

    
//    @Override
//    public String toString() {
//        return "Sexe{" + "sexeId=" + sexeId + ", sexeLibelle=" 
//                + sexeLibelle + ", etudiantList=" + etudiantList + '}';
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.sexeId);
        hash = 11 * hash + Objects.hashCode(this.sexeLibelle);
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
        final Sexe other = (Sexe) obj;
        return Objects.equals(this.sexeId, other.sexeId);
    }
    
    
    
    
}
