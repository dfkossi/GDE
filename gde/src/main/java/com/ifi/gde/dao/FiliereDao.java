/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.dao;

import com.ifi.gde.model.Filiere;
import java.util.List;

/**
 *
 * @author david
 */
public interface FiliereDao {
    void persistFiliere(Filiere filiere);

    Filiere findFiliereById(int id);

    void updateFiliere(Filiere filiere);

    void deleteFiliere(Filiere filiere);

     public List<Filiere> listFilieres();
}