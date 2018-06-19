/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.controller;

import com.ifi.gde.base.dao.HibernateDAO;
import com.ifi.gde.base.dao.InterfaceDAO;
import com.ifi.gde.entity.entities.Sexe;
import com.ifi.gde.entity.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author dfkossi
 */
@ManagedBean(name = "sexeController")
@RequestScoped
public class SexeController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Sexe sexe;
    private List<Sexe> sexeList;
    
     @PostConstruct
    public void init() {
//        professeur = new Professeur();
        sexe = new Sexe();
//        matiere.setMatiereProfesseur(new Professeur());  
        sexeList = getSexeList();
//        professeurList = getProfesseurList();
//        System.out.println("zzz " + professeurList.size());
//        System.out.println("zzz " + matiereList.size());
    }

    private InterfaceDAO<Sexe> sexeDAO() {
        InterfaceDAO<Sexe> sexeDAO = new HibernateDAO<>(Sexe.class,
                FacesContextUtil.getRequestSession());
        return sexeDAO;
    }

//    private InterfaceDAO<Professeur> professeurDAO() {
//        InterfaceDAO<Professeur> professeurDAO = new HibernateDAO<>(Professeur.class,
//                FacesContextUtil.getRequestSession());
//        return professeurDAO;
//    }

    public String clearSexe() {
        sexe = new Sexe();
//        professeur = new Professeur();
        return editSexe();
    }

    public String editSexe() {
        return "/restrict/ajouterSexe.faces";
    }

    public String addMatiere() {
        if (sexe.getSexeId() == null || sexe.getSexeId() == 0) {
            insertSexe();
        } else {
            updateSexe();
        }
        clearSexe();
        return null;
    }

    private void insertSexe() {
//        System.out.println("affiche " + professeur);
//        matiere.setMatiereProfesseur(professeur);
        sexeDAO().save(sexe);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
    }

    private void updateSexe() {
        sexeDAO().update(sexe);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }

    public String deleteMatiere() {
        sexeDAO().remove(sexe);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public Sexe getMatiere() {
        return sexe;
    }

    public void setMatiere(Sexe sexe) {
        this.sexe = sexe;
    }

    public List<Sexe> getSexeList() {
        sexeList = sexeDAO().getEntities();
        return sexeList;
    }

    public void setMatiereList(List<Sexe> sexeList) {
        this.sexeList = sexeList;
    }
    
}
