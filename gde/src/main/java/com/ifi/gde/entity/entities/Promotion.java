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
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author dfkossi
 */
@Entity
@Table(name = "promotion")
public class Promotion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "promotion_id", nullable = false)
    private Integer promoId;
    
    @Column(name = "promoCode", length = 30)
    private String promotionCode;
    
    @Column(name = "DateOuverture", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOuverture;
    
    @Column(name = "DateFermeture", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFermeture;
    
    @OneToMany(mappedBy = "etudiantPromotion", fetch = FetchType.LAZY)
    @ForeignKey(name = "etudiant_promotion")        
    private List<Etudiant> etudiantListPromo;
    
    public Promotion() {
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }    

    public Date getDateOuverture() {
        return this.dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
    
    public Date getDateFermeture() {
        return this.dateFermeture;
    }

    public void setDateFermeture(Date dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public List<Etudiant> getEtudiantListPromo() {
        return etudiantListPromo;
    }

    public void setEtudiantListPromo(List<Etudiant> etudiantListPromo) {
        this.etudiantListPromo = etudiantListPromo;
    }

    @Override
    public String toString() {
        return "Promotion{" + "promoId=" + promoId + ", promotionCode=" +
                promotionCode + ", dateOuverture=" + dateOuverture +
                ", dateFermeture=" + dateFermeture + '}';
    }

    
//    @Override
//    public String toString() {
//        return "Promotion{" + "promoId=" + promoId + ", promotionCode=" +
//                promotionCode + ", dateOuverture=" + dateOuverture +
//                ", dateFermeture=" + dateFermeture + ", etudiantListPromo=" +
//                etudiantListPromo + '}';
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.promoId);
        hash = 73 * hash + Objects.hashCode(this.promotionCode);
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
        final Promotion other = (Promotion) obj;
        return Objects.equals(this.promoId, other.promoId);
    }
       
    
    
}