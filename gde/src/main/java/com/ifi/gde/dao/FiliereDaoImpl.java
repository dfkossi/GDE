/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.dao;

import com.ifi.gde.model.Filiere;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */

@Repository("filiereDao")
public class FiliereDaoImpl implements FiliereDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void persistFiliere(Filiere filiere) {
        sessionFactory.getCurrentSession().save(filiere);
    }

    public Filiere findFiliereById(int id) {
        return (Filiere) sessionFactory.getCurrentSession().get(Filiere.class, id);
    }

    public void updateFiliere(Filiere filiere) {
        sessionFactory.getCurrentSession().update(filiere);
    }

    public void deleteFiliere(Filiere filiere) {
        sessionFactory.getCurrentSession().delete(filiere);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Filiere> listFilieres() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Filiere> filiereList = session.createQuery("from Filieres").list();
        for (Filiere p : filiereList) {
        }
        return filiereList;
    }
}