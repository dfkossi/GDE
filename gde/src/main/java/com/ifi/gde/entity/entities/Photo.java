package com.ifi.gde.entity.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author crakf
 */
@Entity
@Table(name = "photo")
public class Photo implements Serializable{
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="photo_id",nullable=false)
    private int photoId;
    
    @Column(name = "photo_uri")
    private String photoUri;
    
    @Column(name = "photo_dateTaken", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date photoDateTaken;
    
    @Column(name = "photo_contributor")
    private String photoContributor;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "photo_etudiant") 
    @JoinColumn(name="etudiant_id", referencedColumnName = "etudiant_id")
    private Etudiant photoEtudiant;
//    
//    @OneToMany(mappedBy = "etudiantPhoto", fetch = FetchType.LAZY)
//    @ForeignKey(name = "etudiant_photo")        
//    private List<Etudiant> etudiantPhotoList;

    public Photo() {
        this.photoEtudiant = new Etudiant();
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public Etudiant getPhotoEtudiant() {
        return photoEtudiant;
    }

    public void setPhotoEtudiant(Etudiant photoEtudiant) {
        this.photoEtudiant = photoEtudiant;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public Date getPhotoDateTaken() {
        return photoDateTaken;
    }

    public void setPhotoDateTaken(Date photoDateTaken) {
        this.photoDateTaken = photoDateTaken;
    }

    @Override
    public String toString() {
        return "Photo{" + "photoId=" + photoId + ", photoUri=" + photoUri + ", photoDateTaken=" + photoDateTaken + ", photoContributor=" + photoContributor + ", photoEtudiant=" + photoEtudiant + '}';
    }

    public String getPhotoContributor() {
        return photoContributor;
    }

    public void setPhotoContributor(String photoContributor) {
        this.photoContributor = photoContributor;
    }

    
      
    
    
    
    
}
