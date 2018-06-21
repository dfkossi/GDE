/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.controller;

import com.ifi.gde.base.dao.HibernateDAO;
import com.ifi.gde.base.dao.InterfaceDAO;
import com.ifi.gde.entity.entities.Etudiant;
import com.ifi.gde.entity.entities.Matiere;
import com.ifi.gde.entity.entities.Suivre;
import com.ifi.gde.entity.entities.SuivrePK;
import com.ifi.gde.entity.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javafx.scene.control.TreeTableColumn;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author dfkossi
 */
@ManagedBean(name = "noteController")
@RequestScoped
public class NoteController implements Serializable {

    private static final long serialVersionUID = 1L;
    
//    private String etudiant;
//    private String matiere;
    private Suivre suivre;
    private List<Suivre> suivreList;
    private Etudiant etudiant =  new Etudiant();
    private List<Etudiant> etudList;
    
    
    @PostConstruct
    public void init() {
        suivre = new Suivre();
//        suivre.setMatiereNote(new Matiere());
        suivre.setEtudiantNote(new Etudiant());
//        matiere.setMatiereProfesseur(new Professeur());  
        suivreList = getSuivreList();
//        System.out.println("prrrr" + suivreList.size());
        
//        System.out.println("wooooooo " + suivre.getSuivreId());
    }

    private InterfaceDAO<Suivre> suivreDAO() {
        InterfaceDAO<Suivre> suivreDAO = new HibernateDAO<>(Suivre.class,
                FacesContextUtil.getRequestSession());
        return suivreDAO;
    }
    private InterfaceDAO<Etudiant> etudiantDAO() {
        InterfaceDAO<Etudiant> etudiantDAO = new HibernateDAO<>(Etudiant.class,
                FacesContextUtil.getRequestSession());
        return etudiantDAO;
    }
//    public void onRowEdit(RowEditEvent event) {
////        noteId = Integer.toString(suivre.getSuivreId());
//        FacesMessage msg = new FacesMessage("Ligne Edited", 
//                Integer.toString(((Suivre) event.getObject()).getSuivreId()));
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        
//    }
//    public void onRowCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Edit Cancelled", Integer.toString(((Suivre) event.getObject()).getSuivreId()));
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    
    public void onCellEdit(TreeTableColumn.CellEditEvent event) {
        System.out.println("prrrr" + suivre.getEtudiantNote());
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public String clearSuivre() {
        suivre = new Suivre();
//        professeur = new Professeur();
        return editSuivre();
    }

    public String editSuivre() {
        return "/restrict/ajouterNote.faces";
    }

    public String addNote() {
        if (suivre.getSuivreId()!= 0) {
            updateSuivre();
        } else {
            insertSuivre();
        }
        clearSuivre();
        return null;
    }

    private void insertSuivre() {
//        System.out.println("affiche " + professeur);
//        matiere.setMatiereProfesseur(professeur);
        suivreDAO().save(suivre);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
    }

    private void updateSuivre() {
        suivreDAO().update(suivre);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }

    public String deleteSuivre() {
        suivreDAO().remove(suivre);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public Suivre getSuivre() {
        return suivre;
    }

    public void setSuivre(Suivre suivre) {
        this.suivre = suivre;
    }

    public List<Suivre> getSuivreList() {
//        suivreList = suivreDAO().getEntities();
        return suivreList;
    }

    public void setSuivreList(List<Suivre> suivreList) {
        this.suivreList = suivreList;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public List<Etudiant> getEtudList() {
        this.etudList = etudiantDAO().getEntities();
        return etudList;
    }

    public void setEtudList(List<Etudiant> etudList) {
        this.etudList = etudList;
    }

    
    
}
