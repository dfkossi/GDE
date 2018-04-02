/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.beans;

import com.ifi.gde.model.Filiere;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;

import com.ifi.gde.service.FiliereService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import com.sun.faces.util.MessageUtils;
import javax.faces.application.FacesMessage;
/**
 *
 * @author david
 */
@ManagedBean
@SessionScoped
public class FiliereBean implements Serializable {

    @ManagedProperty(value = "#{filiereService}")
    FiliereService filiereService;
    private String codeFiliere;
    private String libeleFiliere;
    public List<Filiere> filieres = new ArrayList<Filiere>();
    public Filiere filiereCtl = new Filiere();
    HtmlForm formulaire;
    HtmlCommandButton maj;

    public void setFiliereService(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public FiliereService getFiliereService() {
        return filiereService;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public String getLibeleFiliere() {
        return libeleFiliere;
    }

    public void setLibeleFiliere(String libeleFiliere) {
        this.libeleFiliere = libeleFiliere;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public Filiere getFiliereCtl() {
        return filiereCtl;
    }

    public void setFiliereCtl(Filiere filiereCtl) {
        this.filiereCtl = filiereCtl;
    }
// method CRUD

    public String persistFiliere() {
        filiereService.persistFiliere(this.filiereCtl);
        return "index";
    }

    public List<Filiere> listFilieres() {
        return this.filiereService.listFilieres();
    }

    public void deleteFiliere(int id) {
        Filiere filiere = (Filiere) filiereService.findFiliereById(id);
        getFiliereService().deleteFiliere(filiere);
    }

    public String editFiliere(Filiere filiereCtl) {
        this.filiereCtl = filiereCtl;
        return "update";
    }

    public String updateFiliere() {
        getFiliereService().updateFiliere(filiereCtl);
        return "index";
    }

    public String showFiliere(Filiere filiereCtl) {
        this.filiereCtl = filiereCtl;
        return "show";
    }
}