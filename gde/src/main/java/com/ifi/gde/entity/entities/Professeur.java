/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.entities;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author dfkossi
 */
//@Entity(name = "professeur")
//@DiscriminatorValue("Professeur")
@Entity
@Table(name = "professeur")
@PrimaryKeyJoinColumn(name = "professeur_id", referencedColumnName = "utilisateur_id")
public class Professeur extends Utilisateur {    
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "professeur_code", length = 30)
    private Integer professeurCode;
    
    @Column(name = "professeur_specialite", length = 60)
    private String professeurSpecialite;
    
    @OneToMany(mappedBy = "matiereProfesseur", fetch = FetchType.LAZY)
    @ForeignKey(name = "matiere_professeur")        
    private List<Matiere> professeurListMat;
    
    public Professeur() {
    }

    public Integer getProfesseurCode() {
        return professeurCode;
    }

    public void setProfesseurCode(Integer professeurCode) {
        this.professeurCode = professeurCode;
    }

    public String getProfesseurSpecialite() {
        return professeurSpecialite;
    }

    public void setProfesseurSpecialite(String professeurSpecialite) {
        this.professeurSpecialite = professeurSpecialite;
    }

    public List<Matiere> getProfesseurListMat() {
        return professeurListMat;
    }

    public void setProfesseurListMat(List<Matiere> professeurListMat) {
        this.professeurListMat = professeurListMat;
    }

    @Override
    public String toString() {
        return "Professeur{" + "professeurCode=" + professeurCode +
                ", professeurSpecialite=" + professeurSpecialite + '}';
    }

    
//    @Override
//    public String toString() {
//        return "Professeur{" + "professeurCode=" + professeurCode + 
//                ", professeurSpecialite=" + professeurSpecialite + 
//                ", professeurListMat=" + professeurListMat + '}';
//    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.professeurCode);
        hash = 19 * hash + Objects.hashCode(this.professeurSpecialite);
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
        final Professeur other = (Professeur) obj;
        return Objects.equals(this.professeurCode, other.professeurCode);
    }

    
    
    
    
    
}