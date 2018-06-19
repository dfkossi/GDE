/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.controller;

import com.ifi.gde.base.dao.InterfaceDAO;
import com.ifi.gde.base.dao.HibernateDAO;
import com.ifi.gde.entity.converter.ConverterSHA1;
import com.ifi.gde.entity.entities.Etudiant;
import com.ifi.gde.entity.entities.Professeur;
import com.ifi.gde.entity.entities.Utilisateur;
import com.ifi.gde.entity.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author dfkossi
 */
@ManagedBean
@SessionScoped
public class UtilisateurController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String pwdConverter;
    
    private Utilisateur utilisateur;
    private Professeur professeur;    
    private Etudiant etudiant;
//    private Sexe sexe;
//    private Promotion promotion;
//    private Filiere filiere;
    
    private List<Professeur> professeurList;
    private List<Utilisateur> utilisateurList;
    private List<Etudiant> etudiantList;
//    private List<Sexe> sexeList;
//    private List<Promotion> promotionList;
//    private List<Filiere> filiereList;
    
    @PostConstruct
    public void init() {
        etudiant = new Etudiant();
//        etudiant.setEtudiantFiliere(new Filiere());
//        etudiant.setEtudiantPromotion(new Promotion());
//        etudiant.setEtudiantSexe(new Sexe());
        
        professeur = new Professeur();
        utilisateur = new Utilisateur();
//        sexe = new Sexe();
//        promotion = new Promotion();
//        filiere = new Filiere();
        
        professeurList = getProfesseurList();
        utilisateurList = getUtilisateurList();
//        sexeList = getSexeList();
//        promotionList = getPromotionList();
//        System.out.println("ZZZZ" + promotionList.size());
//        filiereList = getFiliereList();
        
    }

    private InterfaceDAO<Utilisateur> utilisateurDAO() {
        InterfaceDAO<Utilisateur> utilisateurDAO = new HibernateDAO<>(Utilisateur.class, FacesContextUtil.getRequestSession());
        return utilisateurDAO;
    }

    private InterfaceDAO<Professeur> professeurDAO() {
        InterfaceDAO<Professeur> professeurDAO = new HibernateDAO<>(Professeur.class, FacesContextUtil.getRequestSession());
        return professeurDAO;
    }

    private InterfaceDAO<Etudiant> etudiantDAO() {
        InterfaceDAO<Etudiant> etudiantDAO = new HibernateDAO<>(Etudiant.class, FacesContextUtil.getRequestSession());
        return etudiantDAO;
    }

//    private InterfaceDAO<Sexe> sexeDAO() {
//        InterfaceDAO<Sexe> sexeDAO = new HibernateDAO<>(Sexe.class, FacesContextUtil.getRequestSession());
//        return sexeDAO;
//    }
//
//    private InterfaceDAO<Promotion> promotionDAO() {
//        InterfaceDAO<Promotion> promotionDAO = new HibernateDAO<>(Promotion.class, FacesContextUtil.getRequestSession());
//        return promotionDAO;
//    }
//
//    private InterfaceDAO<Filiere> filiereDAO() {
//        InterfaceDAO<Filiere> filiereDAO = new HibernateDAO<>(Filiere.class, FacesContextUtil.getRequestSession());
//        return filiereDAO;
//    }
    
    public String clearUtilisateur() {
        utilisateur = new Utilisateur();
        return editUtilisateur();
    }

    public String clearProfesseur() {
        professeur = new Professeur();
        return editProfesseur();
    }

    public String clearEtudiant() {
        etudiant = new Etudiant();
//        sexe = new Sexe();
//        promotion = new Promotion();
//        filiere = new Filiere();
        return editEtudiant();
    }
    
    public String editUtilisateur() {
        return "/restrict/ajouterUtilisateur.faces";
    }
    
    public String editProfesseur() {
        return "/restrict/ajouterProfesseur.faces";
    }
    
    public String editEtudiant() {
        return "/restrict/ajouterEtudiant.faces";
    }
    
    public String addUtilisateur() {
        Date date = new Date();
        if (utilisateur.getId() == null || utilisateur.getId() == 0) {
            utilisateur.setUtilisateurDateEnregistrement(date);
            insertUtilisateur();
        } else {
            updateUtilisateur();
        }
        clearUtilisateur();
        return null;
    }

    public String addProfesseur() {
        Date date = new Date();
        if (professeur.getId() == null || professeur.getId() == 0) {
            professeur.setUtilisateurDateEnregistrement(date);
            insertProfesseur();
        } else {
            updateProfesseur();
        }
        return null;
    }

    public String addEtudiant() {
        Date date = new Date();
        if (etudiant.getId() == null || etudiant.getId() == 0) {
            etudiant.setUtilisateurDateEnregistrement(date);
            insertEtudiant();
        } else {
            updateEtudiant();
        }
        clearEtudiant();
        return null;
    }
    
    private void insertUtilisateur() {
        utilisateur.setPassword(ConverterSHA1.cipher(utilisateur.getPassword()));
        if (utilisateur.getPassword() == null ? pwdConverter == null
                : utilisateur.getPassword().equals(ConverterSHA1.cipher(pwdConverter))) {
            utilisateur.setPermission("ROLE_ADMIN");
            utilisateurDAO().save(utilisateur);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Les mots de passe ne correspondent pas.", ""));
        }
    }
    
    private void insertProfesseur() {
        professeur.setPassword(ConverterSHA1.cipher(professeur.getPassword()));
        if (professeur.getPassword() == null ? pwdConverter == null
                : professeur.getPassword().equals(ConverterSHA1.cipher(pwdConverter))) {
            professeur.setPermission("ROLE_USER");
            professeurDAO().save(professeur);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Les mots de passe ne correspondent pas.", ""));
        }
    }
    
    private void insertEtudiant() {
        etudiant.setPassword(ConverterSHA1.cipher(etudiant.getPassword()));
        if (etudiant.getPassword() == null ? pwdConverter == null
                : etudiant.getPassword().equals(ConverterSHA1.cipher(pwdConverter))) {
            etudiant.setPermission("ROLE_USER");
//            etudiant.setEtudiantSexe(sexe);
//            etudiant.setEtudiantFiliere(filiere);
//            etudiant.setEtudiantPromotion(promotion);
            etudiantDAO().save(etudiant);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Les mots de passe ne correspondent pas.", ""));
        }
    }
    
    private void updateProfesseur() {
        professeurDAO().update(professeur);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }

    private void updateUtilisateur() {
        utilisateurDAO().update(utilisateur);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }

    private void updateEtudiant() {
        etudiantDAO().update(etudiant);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }
    
    public String deleteUtilisateur() {
        utilisateurDAO().remove(utilisateur);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public String deleteProfesseur() {
        professeurDAO().remove(professeur);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public String deleteEtudiant() {
        etudiantDAO().remove(etudiant);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }
    
    public String getPwdConverter() {
        return pwdConverter;
    }
    
    public void setPwdConverter(String pwdConverter) {
        this.pwdConverter = pwdConverter;
    }
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public Professeur getProfesseur() {
        return professeur;
    }
    
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    
    public List<Professeur> getProfesseurList() {
        professeurList = professeurDAO().getEntities();
        return professeurList;
    }
    
    public void setProfesseurList(List<Professeur> professeurList) {
        this.professeurList = professeurList;
    }
    
    public List<Utilisateur> getUtilisateurList() {
        utilisateurList = utilisateurDAO().getEntities();
        return utilisateurList;
    }
    
    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }
    
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
    public List<Etudiant> getEtudiantList() {
        etudiantList = etudiantDAO().getEntities();
        return etudiantList;
    }
    
    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }
    
//    public Sexe getSexe() {
//        return sexe;
//    }
//    
//    public void setSexe(Sexe sexe) {
//        this.sexe = sexe;
//    }
//    
//    public Promotion getPromotion() {
//        return promotion;
//    }
//    
//    public void setPromotion(Promotion promotion) {
//        this.promotion = promotion;
//    }
//    
//    public Filiere getFiliere() {
//        return filiere;
//    }
//    
//    public void setFiliere(Filiere filiere) {
//        this.filiere = filiere;
//    }
    
//    public List<Sexe> getSexeList() {
//        sexeList = sexeDAO().getEntities();
//        return sexeList;
//    }
//    
//    public void setSexeListist(List<Sexe> sexeList) {
//        this.sexeList = sexeList;
//    }
//    
//    public List<Promotion> getPromotionList() {
//        promotionList = promotionDAO().getEntities();
//        return promotionList;
//    }
//    
//    public void setPromotionList(List<Promotion> promotionList) {
//        this.promotionList = promotionList;
//    }
//    
//    public List<Filiere> getFiliereList() {
//        filiereList = filiereDAO().getEntities();
//        return filiereList;
//    }
//    
//    public void setFiliereList(List<Filiere> filiereList) {
//        this.filiereList = filiereList;
//    }
    
}
