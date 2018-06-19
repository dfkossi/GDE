/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.entities;

import com.ifi.gde.entity.converter.ConverterSHA1;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author dfkossi
 */

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Utilisateur_Type")
@Entity
@Table(name="utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilisateur implements Serializable{
    
    private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "utilisateur_id", nullable = false)
    private Integer id;
    
    @Column(name = "utilisateur_nom", length = 40)
    private String utilisateurNom;
    
    @Column(name = "utilisateur_prenom", length = 40)
    private String utilisateurPrenom;
    
    @Column (name="utilisateur_telephone", nullable = false, length = 22 )//(+84)-96-76-30-365
    private String utilisateurTelephone;
    
    @Column(name = "utilisateur_date_enregistrement", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date utilisateurDateEnregistrement;
    
    @Column (name="utilisateur_email", nullable = false, length = 80 )
    private String utilisateurEmail;
    
    @Column(name = "login", unique=true, length = 25)
    private String login;
    @Column(name = "password", length = 40)
    private String password;
    @Column(name = "permission", length = 36)
    private String permission;     
    
    public Utilisateur() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUtilisateurNom() {
        return utilisateurNom;
    }

    public void setUtilisateurNom(String utilisateurNom) {
        this.utilisateurNom = utilisateurNom;
    }

    public String getUtilisateurPrenom() {
        return utilisateurPrenom;
    }

    public void setUtilisateurPrenom(String utilisateurPrenom) {
        this.utilisateurPrenom = utilisateurPrenom;
    }

    public String getUtilisateurTelephone() {
        return utilisateurTelephone;
    }

    public void setUtilisateurTelephone(String utilisateurTelephone) {
        this.utilisateurTelephone = utilisateurTelephone;
    }

    public String getUtilisateurEmail() {
        return utilisateurEmail;
    }

    public void setUtilisateurEmail(String utilisateurEmail) {
        this.utilisateurEmail = utilisateurEmail;
    }
    

    public Date getUtilisateurDateEnregistrement() {
        return utilisateurDateEnregistrement;
    }

    public void setUtilisateurDateEnregistrement(Date utilisateurDateEnregistrement) {
        this.utilisateurDateEnregistrement = utilisateurDateEnregistrement;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", utilisateurNom=" + utilisateurNom +
                ", utilisateurPrenom=" + utilisateurPrenom + ", utilisateurTelephone=" +
                utilisateurTelephone + ", utilisateurDateEnregistrement=" + 
                utilisateurDateEnregistrement + ", utilisateurEmail=" + utilisateurEmail +
                ", login=" + login + ", password=" + password + ", permission=" + permission + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.utilisateurNom);
        hash = 67 * hash + Objects.hashCode(this.utilisateurPrenom);
        hash = 67 * hash + Objects.hashCode(this.utilisateurTelephone);
        hash = 67 * hash + Objects.hashCode(this.utilisateurDateEnregistrement);
        hash = 67 * hash + Objects.hashCode(this.utilisateurEmail);
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.permission);
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
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
