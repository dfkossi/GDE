/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.service;

import com.ifi.gde.dao.FiliereDao;
import com.ifi.gde.model.Filiere;
import java.util.List;
//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service("filiereService")
public class FiliereServiceImpl implements FiliereService {

    @Autowired
    FiliereDao filiereDao;

    @Transactional
    public void persistFiliere(Filiere filiere) {
        filiereDao.persistFiliere(filiere);
    }

    @Transactional
    public Filiere findFiliereById(int id) {
        return filiereDao.findFiliereById(id);
    }

    @Transactional
    public void updateFiliere(Filiere filiere) {
        filiereDao.updateFiliere(filiere);
    }

    @Transactional
    public void deleteFiliere(Filiere filiere) {
        filiereDao.deleteFiliere(filiere);
    }

    @Override
    @Transactional
    public List<Filiere> listFilieres() {
        return this.filiereDao.listFilieres();
    }

    @Override
    public List<Filiere> listUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}