/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.controller;

import com.ifi.gde.base.dao.HibernateDAO;
import com.ifi.gde.base.dao.InterfaceDAO;
import com.ifi.gde.entity.entities.Matiere;
import com.ifi.gde.entity.entities.Professeur;
import com.ifi.gde.entity.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author dfkossi
 */
@ManagedBean
@RequestScoped
public class MatiereController implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Matiere matiere;
    private Professeur professeur;
    private List<Matiere> matiereList;
    private List<Professeur> professeurList;
    
    
    private InterfaceDAO<Matiere> matiereDAO(){
        InterfaceDAO<Matiere> matiereDAO = new HibernateDAO<>(Matiere.class, FacesContextUtil.getRequestSession());
        return matiereDAO;
    }
    private InterfaceDAO<Professeur> professeurDAO(){
        InterfaceDAO<Professeur> professeurDAO = new HibernateDAO<>(Professeur.class, FacesContextUtil.getRequestSession());
        return professeurDAO;
    }
    
    public String clearMatiere(){
        matiere = new Matiere();
        professeur = new Professeur();
        return editMatiere();
    }
    
    public String editMatiere() {
        return "/restrict/ajouterMatiere.faces";
    }
    
    public String addMatiere(){
        if(matiere.getMatiereId() == null || matiere.getMatiereId() == 0){
            insertMatiere();
        }else{
            updateMatiere();
        }
        clearMatiere();
        return null;
    }
    
    private void insertMatiere(){
            matiere.setProfesseur(professeur);
            matiereDAO().save(matiere);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
    }
    
    private void updateMatiere(){
        matiereDAO().update(matiere);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }
    public String deleteMatiere(){
        matiereDAO().remove(matiere);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public List<Matiere> getMatiereList() {
        matiereList = matiereDAO().getEntities();
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }
    
    

}
