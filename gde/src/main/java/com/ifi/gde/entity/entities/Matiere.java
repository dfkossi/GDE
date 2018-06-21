
package com.ifi.gde.entity.entities;

/**
 *
 * @author peniel
 */
//package com.ifi.gde.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @Column(name = "matiere_code", length = 30)
    private String matiereCode;
    @Column(name = "matiere_titre", length = 40)
    private String matiereTitre;
    @Column(name = "matiere_nbre_heure", length = 20)
    private Integer matiereNbreHeure;
    @Column(name = "matiere_nbre_ects", length = 20)
    private Integer matiereNombreECTS;
   
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "matiere_professeur") 
    @JoinColumn(name="professeur_id", referencedColumnName = "professeur_id")
    private Professeur matiereProfesseur;
    
    @OneToMany(mappedBy = "matiereNote", fetch = FetchType.LAZY)
    @ForeignKey(name = "matiere_note")        
    private List<Suivre> matiereList;
    
    public Matiere() {
        this.matiereProfesseur = new Professeur();
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

    public Professeur getMatiereProfesseur() {
        return matiereProfesseur;
    }

    public void setMatiereProfesseur(Professeur matiereProfesseur) {
        this.matiereProfesseur = matiereProfesseur;
    }

    public List<Suivre> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Suivre> matiereList) {
        this.matiereList = matiereList;
    }

    @Override
    public String toString() {
        return "Matiere{" + "matiereId=" + matiereId + ", matiereCode=" +
                matiereCode + ", matiereTitre=" + matiereTitre + 
                ", matiereNbreHeure=" + matiereNbreHeure +
                ", matiereNombreECTS=" + matiereNombreECTS + 
                ", matiereProfesseur=" + matiereProfesseur + '}';
    }

    
//    @Override
//    public String toString() {
//        return "Matiere{" + "matiereId=" + matiereId + ","
//                + " matiereCode=" + matiereCode + ", matiereTitre=" 
//                + matiereTitre + ", matiereNbreHeure=" + matiereNbreHeure +
//                ", matiereNombreECTS=" + matiereNombreECTS + ", "
//                + "matiereProfesseur=" + matiereProfesseur + ", "
//                + "matiereList=" + matiereList + '}';
//    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.matiereId);
        hash = 23 * hash + Objects.hashCode(this.matiereCode);
        hash = 23 * hash + Objects.hashCode(this.matiereTitre);
        hash = 23 * hash + Objects.hashCode(this.matiereNbreHeure);
        hash = 23 * hash + Objects.hashCode(this.matiereNombreECTS);
        hash = 23 * hash + Objects.hashCode(this.matiereProfesseur);
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
        return Objects.equals(this.matiereCode, other.matiereCode);
    }

    

    
    
    
    
    
}
