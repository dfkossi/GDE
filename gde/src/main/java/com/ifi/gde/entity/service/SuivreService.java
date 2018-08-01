/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.service;

import com.ifi.gde.base.repository.SuivreRepository;
import com.ifi.gde.entity.entities.Suivre;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crakf
 */
@Service
public class SuivreService {
    
    @Autowired
    private SuivreRepository sr;
    
    public List<Suivre> findNoteByStudent(Integer id){
        
        List<Suivre> listNotes = new ArrayList<>();
        listNotes = sr.findNoteByStudent(id);
        return listNotes;
    }
}
