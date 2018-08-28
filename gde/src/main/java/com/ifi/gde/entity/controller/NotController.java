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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author dfkossi
 */
@ManagedBean(name = "notController")
@ViewScoped
public class NotController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Suivre note;

    private Matiere matiere;
    private Etudiant etudiant;
    private Integer idM;
//    private Professeur professeur;
    private List<Suivre> notList;
    private List<Suivre> notList2;
    private List<Suivre> noteTestList;
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
        noteTestList = new ArrayList<>();
        note = new Suivre();
        matiereList = matiereDAO().getEntities();
        suivreList = getSuivreList();
        suivreList2 = getSuivreList2();
        for (Matiere mm : matiereList) {
            System.out.println(" hhhhhhhhh  " + mm);
        }

        etudiantList = etudiantDAO().getEntities();
        etudiantList2 = etudiantDAO().getEntities();


//        for (Suivre s : suivreList) {
//            int l = 0;
//            for (Etudiant et : etudiantList) {
//                if (et.getId() == s.getEtudiantNote().getId()) {
//                    l = 1;
//                    break;
//                }
//                if (l == 0) {
//                    etudiantList2.add(s.getEtudiantNote());
//                }
//            }
//
//        }
   for (Suivre s : suivreList) {
            int o = 0;
            List<Etudiant> lk=new ArrayList();
            lk.addAll(etudiantList2);
            for (Etudiant et : lk) {
                if (et.getId() == s.getEtudiantNote().getId()) {
                    o = 1;
                    break;
                }
             }
             if (o == 0) {
                    etudiantList2.add(s.getEtudiantNote());
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
    int idtemporaire = 1;

    public void populateList() {
        Suivre ss;

        for (Etudiant e : selectedEdutiants) {
            int j = 0;

            for (Suivre n : notList) {
                System.out.println(" note " + n.getEtudiantNote() + " etud  " + e);
                if (n.getEtudiantNote().getId() == e.getId()) {

                    j = 1;
                    System.out.println("   j = 1" + j);
                    break;

                }

            }
            System.out.println("   jj " + j);
            if (j == 0) {
                ss = new Suivre();
                ss.setEtudiantNote(e);
                ss.setSuivreId(idtemporaire);
                idtemporaire++;
                notList.add(ss);

            }

        }
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
        matiere = new Matiere();
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

    public String clearNoteSuivre() {
        note = new Suivre();
//        professeur = new Professeur();
        return editNoteSuivre();
    }

    public String editNoteSuivre() {
        return "/restrict/consulterNote.faces";
    }

    public String addSuivre() {
        // if (note.getSuivreId() != null && note.getSuivreId() != 0) {
        // updateSuivre();
        //} else {
//        clearSuivre();
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
    
    private void insertSuivre() {
        int i = 0;
        int k = 0;
//        note.setSuivreProfesseur(professeur);
        for (Suivre sv : notList) {
            System.out.println("affichepppppppppppppppppppp " + 2);
            if (sv.getNoteObtenue() == null) {
                i =  1;
            }
        }
        if (i == 1 ) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Erreur: une note n'a pas été renseigné", ""));
            }
        //for (Suivre sv2 : notList) {
        for (Suivre sv : notList) {
//           
            k = 0;
            sv.setSuivreId(null);
            sv.setMatiereNote(matiere);

            for (Suivre sv2 : suivreList) {
                if (sv.getMatiereNote().getMatiereId() == sv2.getMatiereNote().getMatiereId()
                        && sv.getEtudiantNote().getId() == sv2.getEtudiantNote().getId()) {
                    k = 1;
                }

            }
            if (suivreList.size() == 0 || k != 1) {
                if (sv.getNoteObtenue() == null) {
                    i = 2;
                    suivreDAO().save(sv);
                } else if (sv.getNoteObtenue() >= 0 || sv.getNoteObtenue() <= 20) {
                    i = 2;
                    suivreDAO().save(sv);
                }
            }

        }
        if (k == 1) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: certains étudiants ont déjà des notes pour cette matière", ""));
        }
        if (i == 2) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
        }
        suivreList = getSuivreList();
        idtemporaire = 1;

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

    public void deleteLigne(Suivre ss) {
        List<Suivre> l = new ArrayList<>();
        l.addAll(notList);
        for (Suivre s : l) {
            if (s.getSuivreId() == ss.getSuivreId()) {
                notList.remove(s);
                break;
            }
        }
        System.out.println("taille liste" + notList.size());
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

    public List<Suivre> getNoteTestList() {
        return noteTestList;
    }

    public void setNoteTestList(List<Suivre> noteTestList) {
        this.noteTestList = noteTestList;
    }

}

//Erreur de conversion lors de la définition de la valeur «Professeur{professeurCode=123, 
//professeurSpecialite=GENIE LOGICIEL, professeurListMat=[]}» pour «null Converter».
