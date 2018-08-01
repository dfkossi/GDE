/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.base.repository;

import com.ifi.gde.entity.entities.Suivre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crakf
 */
@Repository
public interface SuivreRepository extends JpaRepository<Suivre, Integer>{
    @Query("SELECT c FROM  notes c WHERE c.etudiant_id=:idf")
    List<Suivre> findNoteByStudent(@Param("idf") Integer idf);
}
