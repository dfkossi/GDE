/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author dfkossi
 */
//@Entity(name = "etudiant")
//@DiscriminatorValue("Etudiant")
@Entity
@Table(name = "etudiant")
@PrimaryKeyJoinColumn(name = "etudiant_id", referencedColumnName = "utilisateur_id")
public class Etudiant extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "etudiant_matricule", nullable = false, length = 30)
    private Integer etudiantNumMatricule;

    @Column(name = "etudiant_date_nais", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date etudiantDateNais;

    @Column(name = "etudiant_nationalite", length = 30)
    private String etudiantNationalite;
    
    @Column(name = "etudiant_average", length = 30)
    private Double etudiantAverage;
    
//    @Lob
//    @Column(name="etudiant_photo", nullable=false, columnDefinition="mediumblob")
//    private byte[] etudiantPhoto;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_sexe")
    @JoinColumn(name = "sexe_id", referencedColumnName = "sexe_id")
    private Sexe etudiantSexe;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_filiere")
    @JoinColumn(name = "filiere_id", referencedColumnName = "filiere_id", nullable = false)
    private Filiere etudiantFiliere;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_promotion")
    @JoinColumn(name = "promotion_id", referencedColumnName = "promotion_id")
    private Promotion etudiantPromotion;

    @OneToMany(mappedBy = "etudiantNote", fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_note")
    private List<Suivre> etudiantList;
//    
//    @ManyToOne(optional=false, fetch = FetchType.LAZY)
//    @ForeignKey(name = "photo_etudiant") 
//    @JoinColumn(name="etudiant_id", referencedColumnName = "etudiant_id")
//    private Etudiant photoEtudiant;
//    
    @OneToMany(mappedBy = "photoEtudiant", fetch = FetchType.LAZY)
    @ForeignKey(name = "photo_etudiant")        
    private List<Photo> photoEtudiantList;

    public Etudiant() {
        this.etudiantSexe = new Sexe();
        this.etudiantFiliere = new Filiere();
        this.etudiantPromotion = new Promotion();
    }

    public Integer getEtudiantNumMatricule() {
        return etudiantNumMatricule;
    }

    public void setEtudiantNumMatricule(Integer etudiantNumMatricule) {
        this.etudiantNumMatricule = etudiantNumMatricule;
    }

    public Date getEtudiantDateNais() {
        return etudiantDateNais;
    }

    public void setEtudiantDateNais(Date etudiantDateNais) {
        this.etudiantDateNais = etudiantDateNais;
    }

    public String getEtudiantNationalite() {
        return etudiantNationalite;
    }

    public void setEtudiantNationalite(String etudiantNationalite) {
        this.etudiantNationalite = etudiantNationalite;
    }

    public Sexe getEtudiantSexe() {
        return etudiantSexe;
    }

    public void setEtudiantSexe(Sexe etudiantSexe) {
        this.etudiantSexe = etudiantSexe;
    }

    public Filiere getEtudiantFiliere() {
        return etudiantFiliere;
    }

    public void setEtudiantFiliere(Filiere etudiantFiliere) {
        this.etudiantFiliere = etudiantFiliere;
    }

    public Promotion getEtudiantPromotion() {
        return etudiantPromotion;
    }

    public void setEtudiantPromotion(Promotion etudiantPromotion) {
        this.etudiantPromotion = etudiantPromotion;
    }

    public List<Suivre> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Suivre> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public List<Photo> getPhotoEtudiantList() {
        return photoEtudiantList;
    }

    public void setPhotoEtudiantList(List<Photo> photoEtudiantList) {
        this.photoEtudiantList = photoEtudiantList;
    }

    public Double getEtudiantAverage() {
        return etudiantAverage;
    }

    public void setEtudiantAverage(Double etudiantAverage) {
        this.etudiantAverage = etudiantAverage;
    }

    
    
//    @Override
//    public String toString() {
//        return "Etudiant{" + "etudiantNumMatricule=" + etudiantNumMatricule +
//                ", etudiantDateNais=" + etudiantDateNais +
//                ", etudiantNationalite=" + etudiantNationalite + 
//                ", etudiantSexe=" + etudiantSexe + ", etudiantFiliere=" +
//                etudiantFiliere + ", etudiantPromotion=" + etudiantPromotion + '}';
//    }
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.etudiantNumMatricule);
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
        final Etudiant other = (Etudiant) obj;
        if (!Objects.equals(this.etudiantNumMatricule, other.etudiantNumMatricule)) {
            return false;
        }
        return true;
    }

}
