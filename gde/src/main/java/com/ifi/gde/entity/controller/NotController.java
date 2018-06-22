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
import com.ifi.gde.entity.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author dfkossi
 */
@ManagedBean(name = "notController")
@RequestScoped
public class NotController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Suivre note;

    private Matiere matiere;
    private Etudiant etudiant;
    private Integer idM;
//    private Professeur professeur;
    private List<Suivre> notList;
    private List<Suivre> notList2;
    private List<Suivre> filteredEdutiants;
    private List<Etudiant> selectedEdutiants;
    private List<Matiere> matiereList;
    private List<Etudiant> etudiantList;
    private List<Etudiant> etudiantList2;
    private List<Suivre> suivreList;
    private List<Suivre> suivreList2;

//    public SuivreController() {
//    }
    @PostConstruct
    public void init() {
//        professeur = new Professeur();
        matiere = new Matiere();
        etudiant = new Etudiant();
        notList = new ArrayList<>();
        filteredEdutiants = new ArrayList<>();
        selectedEdutiants = new ArrayList<>();
        notList2 = new ArrayList<>();
        note = new Suivre();
        matiereList = matiereDAO().getEntities();
        suivreList = getSuivreList();
        suivreList2 = getSuivreList2();
        for (Matiere mm : matiereList) {
            System.out.println(" hhhhhhhhh  " + mm);
        }

        etudiantList = etudiantDAO().getEntities();
        etudiantList2 = etudiantDAO().getEntities();
        Suivre ss = new Suivre();
        int i = 1;
        for (Etudiant e : etudiantList) {

            ss = new Suivre();
            ss.setEtudiantNote(e);
            ss.setSuivreId(i);
            i++;
            notList.add(ss);
        }
//        Suivre ssa = new Suivre();
        for (Suivre s : suivreList) {
            for (Etudiant et : etudiantList) {
                if(et.getUtilisateurNom().equals(s.getEtudiantNote().getUtilisateurNom())){
                    for(Etudiant e: etudiantList2){
                        if(etudiantList2.contains(e)){
                            etudiantList2.add(et);
                        }
                }
                }
            }
        }
//        for (Etudiant et : etudiantList) {
//            for (Suivre s : suivreList) {
//                if (s.getEtudiantNote().getUtilisateurNom().equals(et.getUtilisateurNom())) {
////                if (Objects.equals(et.getUtilisateurNom(), s.getEtudiantNote().getUtilisateurNom())) {
//                    for (Suivre sss : suivreList2) {
//                        if (suivreList2.contains(sss)) {
//                            
//                            sss = new Suivre();
//                            sss.setEtudiantNote(et);
//                            suivreList2.add(sss);
//                        }
//                    }
//                }
//            }
//        }
//        
//        }
//        professeurList = getProfesseurList();
//        System.out.println("zzz " + professeurList.size());
//        System.out.println("zzz " + notList.size());
    }

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }

    private InterfaceDAO<Suivre> suivreDAO() {
        InterfaceDAO<Suivre> suivreDAO = new HibernateDAO<>(Suivre.class,
                FacesContextUtil.getRequestSession());
        return suivreDAO;
    }

    private InterfaceDAO<Etudiant> etudiantDAO() {
        InterfaceDAO<Etudiant> etudiantDAO = new HibernateDAO<>(Etudiant.class, FacesContextUtil.getRequestSession());
        return etudiantDAO;
    }

    private InterfaceDAO<Matiere> matiereDAO() {
        InterfaceDAO<Matiere> matiereDAO = new HibernateDAO<>(Matiere.class,
                FacesContextUtil.getRequestSession());
        return matiereDAO;
    }

//    private InterfaceDAO<Professeur> professeurDAO() {
//        InterfaceDAO<Professeur> professeurDAO = new HibernateDAO<>(Professeur.class,
//                FacesContextUtil.getRequestSession());
//        return professeurDAO;
//    }
    public String clearSuivre() {
        note = new Suivre();
//        professeur = new Professeur();
        return editSuivre();
    }

    public String editSuivre() {
        return "/restrict/ajouterNot.faces";
    }

    public String clearFiltreSuivre() {
        note = new Suivre();
//        professeur = new Professeur();
        return editFiltreSuivre();
    }

    public String editFiltreSuivre() {
        return "/restrict/consulterEtudiant.faces";
    }

    public String addSuivre() {
        // if (note.getSuivreId() != null && note.getSuivreId() != 0) {
        // updateSuivre();
        //} else {
        System.out.println("hhhhhhhhhhhh  " + notList2.size());
        insertSuivre();
        //  }
        clearSuivre();
        return null;
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        System.out.println("=====================================  " + newValue);
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Etudiant) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
//    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Car Unselected", ((Etudiant) event.getObject()).toString());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    
    private void insertSuivre() {

//        note.setSuivreProfesseur(professeur);
        for (Suivre sv : notList) {
            System.out.println("affichepppppppppppppppppppp " + sv.getNoteObtenue());
            sv.setSuivreId(null);
            sv.setMatiereNote(matiere);
            suivreDAO().save(sv);
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
    }

    private void updateSuivre() {
        suivreDAO().update(note);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }

    public String deleteSuivre(Suivre ss) {
        suivreDAO().remove(ss);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public void onRowEdit(RowEditEvent event) {
        Suivre m = (Suivre) event.getObject();
        suivreDAO().update(m);

    }

    public void onRowEdit1(RowEditEvent event) {
        for (Suivre sv : notList) {
            System.out.println("affichepppppppppppppppppppp " + sv.getNoteObtenue());

        }
        Suivre m = (Suivre) event.getObject();
        for (Suivre sv : notList) {
            if (sv.getSuivreId() == m.getSuivreId()) {
                sv.setNoteObtenue(m.getNoteObtenue());
                break;
            }

        }

        System.out.println("$$$$$$$$$$$$$$$$ av " + notList2.size());
        notList2.add(m);
        System.out.println("$$$$$$$$$$$$$$$$ ap " + notList2.size());

    }

    public void onRowCancel(RowEditEvent event) {

    }

    public Suivre getNote() {
        return note;
    }

    public List<Suivre> getSuivreList() {
        suivreList = suivreDAO().getEntities();
        return suivreList;
    }

    public List<Suivre> getNotList2() {
        return notList2;
    }

    public void setNotList2(List<Suivre> notList2) {
        this.notList2 = notList2;
    }

    public void setSuivreList(List<Suivre> suivreList) {
        this.suivreList = suivreList;
    }

    public void setNote(Suivre note) {
        this.note = note;
    }

    public List<Suivre> getNotList() {
//        notList = suivreDAO().getEntities();
        return notList;
    }

    public void setNotList(List<Suivre> notList) {
        this.notList = notList;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public List<Suivre> getFilteredEdutiants() {
        return filteredEdutiants;
    }

    public void setFilteredEdutiants(List<Suivre> filteredEdutiants) {
        this.filteredEdutiants = filteredEdutiants;
    }

    public List<Suivre> getSuivreList2() {
        return suivreList2;
    }

    public void setSuivreList2(List<Suivre> suivreList2) {
        this.suivreList2 = suivreList2;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public List<Etudiant> getEtudiantList2() {
        return etudiantList2;
    }

    public void setEtudiantList2(List<Etudiant> etudiantList2) {
        this.etudiantList2 = etudiantList2;
    }

    public List<Etudiant> getSelectedEdutiants() {
        return selectedEdutiants;
    }

    public void setSelectedEdutiants(List<Etudiant> selectedEdutiants) {
        this.selectedEdutiants = selectedEdutiants;
    }

}

//Erreur de conversion lors de la définition de la valeur «Professeur{professeurCode=123, 
//professeurSpecialite=GENIE LOGICIEL, professeurListMat=[]}» pour «null Converter».
