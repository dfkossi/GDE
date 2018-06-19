/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.entity.controller;

import com.ifi.gde.base.dao.HibernateDAO;
import com.ifi.gde.base.dao.InterfaceDAO;
import com.ifi.gde.entity.entities.Promotion;
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
@ManagedBean(name="promotionController")
@RequestScoped
public class PromotionController implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Promotion promotion = new Promotion();
    private List<Promotion> promotionList;

    public PromotionController() {
    }    
    
    private InterfaceDAO<Promotion> promotionDAO(){
        InterfaceDAO<Promotion> promotionDAO = new HibernateDAO<>(Promotion.class, FacesContextUtil.getRequestSession());
        return promotionDAO;
    }
    
    public String clearPromotion(){
        promotion = new Promotion();
        return editPromotion();
    }
    
    public String editPromotion() {
        return "/restrict/ajouterPromotion.faces";
    }
    
    public String addPromotion(){
        if(promotion.getPromoId() == null || promotion.getPromoId() == 0){
            insertPromotion();
        }else{
            updatePromotion();
        }
        clearPromotion();
        return null;
    }
    
    private void insertPromotion(){
            promotionDAO().save(promotion);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
    }
    
    private void updatePromotion(){
        promotionDAO().update(promotion);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }
    
    public String deletePromotion(){
        promotionDAO().remove(promotion);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<Promotion> getPromotionList() {
        promotionList = promotionDAO().getEntities();
        return promotionList;
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    
}
