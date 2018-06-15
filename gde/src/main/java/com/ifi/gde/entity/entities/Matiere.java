
package com.ifi.gde.entity.entities;

/**
 *
 * @author peniel
 */
//package com.ifi.gde.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "matiere")
public class Matiere implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matiere_id")
    private Integer matiereId;
    @Column(name = "matiereCode", length = 30)
    private String matiereCode;
    @Column(name = "matiere_titre", length = 20)
    private String matiereTitre;
    @Column(name = "matiere_nbre_heure", length = 20)
    private Integer matiereNbreHeure;
    @Column(name = "matiere_nbre_ects", length = 20)
    private Integer matiereNombreECTS;
   
    @ManyToOne(optional=false)
    @ForeignKey(name = "matiere_professeur") 
    @JoinColumn(name="professeur_id", referencedColumnName = "professeur_id")
    private Professeur professeur;
    
    public Matiere() {
    }   

    public Integer getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(Integer matiereId) {
        this.matiereId = matiereId;
    }

    public String getMatiereCode() {
        return matiereCode;
    }

    public void setMatiereCode(String matiereCode) {
        this.matiereCode = matiereCode;
    }

    
    public String getMatiereTitre() {
        return matiereTitre;
    }

    public void setMatiereTitre(String matiereTitre) {
        this.matiereTitre = matiereTitre;
    }

    public Integer getMatiereNbreHeure() {
        return matiereNbreHeure;
    }

    public void setMatiereNbreHeure(Integer matiereNbreHeure) {
        this.matiereNbreHeure = matiereNbreHeure;
    }

    public Integer getMatiereNombreECTS() {
        return matiereNombreECTS;
    }

    public void setMatiereNombreECTS(Integer matiereNombreECTS) {
        this.matiereNombreECTS = matiereNombreECTS;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        return "Matiere{" + "matiereId=" + matiereId + ", matiereCode=" 
                + matiereCode + ", matiereTitre=" + matiereTitre + 
                ", matiereNbreHeure=" + matiereNbreHeure + 
                ", matiereNombreECTS=" + matiereNombreECTS + 
                ", professeur=" + professeur + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.matiereId);
        hash = 23 * hash + Objects.hashCode(this.matiereCode);
        hash = 23 * hash + Objects.hashCode(this.matiereTitre);
        hash = 23 * hash + Objects.hashCode(this.matiereNbreHeure);
        hash = 23 * hash + Objects.hashCode(this.matiereNombreECTS);
        hash = 23 * hash + Objects.hashCode(this.professeur);
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
        final Matiere other = (Matiere) obj;
        if (!Objects.equals(this.matiereId, other.matiereId)) {
            return false;
        }
        if (!Objects.equals(this.matiereCode, other.matiereCode)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    
}
