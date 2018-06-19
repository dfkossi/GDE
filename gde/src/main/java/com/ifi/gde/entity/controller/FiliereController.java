/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.controller;

import com.ifi.gde.base.dao.HibernateDAO;
import com.ifi.gde.base.dao.InterfaceDAO;
import com.ifi.gde.entity.entities.Filiere;
import com.ifi.gde.entity.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author dfkossi
 */
@ManagedBean(name = "filiereController")
@RequestScoped
public class FiliereController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Filiere filiere = new Filiere();;
    private List<Filiere> filiereList = new ArrayList<>();


    public FiliereController() {
    }

    private InterfaceDAO<Filiere> filiereDAO() {
        InterfaceDAO<Filiere> filiereDAO = new HibernateDAO<>(Filiere.class, FacesContextUtil.getRequestSession());
        return filiereDAO;
    }

    public String clearFiliere() {
        filiere = new Filiere();
        return editFiliere();
    }

    public String editFiliere() {
        return "/restrict/ajouterFiliere.faces";
    }

    public String addFiliere() {
        if (filiere.getFiliereId() == null || filiere.getFiliereId() == 0) {
            insertFiliere();
        } else {
            updateFiliere();
        }
        clearFiliere();
        return null;
    }

    private void insertFiliere() {
        filiereDAO().save(filiere);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
    }

    private void updateFiliere() {
        filiereDAO().update(filiere);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }

    public String deleteFiliere() {
        filiereDAO().remove(filiere);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<Filiere> getFiliereList() {
        filiereList = filiereDAO().getEntities();
        return filiereList;
    }

    public void setFiliereList(List<Filiere> filiereList) {
        this.filiereList = filiereList;
    }

}
