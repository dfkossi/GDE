package com.ifi.gde.entity.controller;

import com.ifi.gde.base.dao.HibernateDAO;
import com.ifi.gde.base.dao.InterfaceDAO;
import com.ifi.gde.entity.entities.Photo;
import com.ifi.gde.entity.entities.Sexe;
import com.ifi.gde.entity.util.FacesContextUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author dfkossi
 */
@ManagedBean(name = "photoController")
@ViewScoped
public class PhotoController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Photo photo;
    private List<Photo> photoList;
    
    //private File file;
    private UploadedFile file;
    
    @PostConstruct
    public void init() {
        photo = new Photo();
        photoList = getPhotoList();
    }

    private InterfaceDAO<Photo> photoDAO() {
        InterfaceDAO<Photo> photoDAO = new HibernateDAO<>(Photo.class,
                FacesContextUtil.getRequestSession());
        return photoDAO;
    }
    
    public String clearPhoto() {
        photo = new Photo();
//        professeur = new Professeur();
        return editPhoto();
    }

    public String editPhoto() {
        return "/restrict/ajouterPhoto.faces";
    }

    public String addPhoto() {
        Date date = new Date();
        if (photo.getPhotoId() == 0) {
            photo.setPhotoDateTaken(date);
            insertPhoto();
        } else {
            updatePhoto();
        }
        clearPhoto();
        return null;
    }

    private void insertPhoto() {
        photoDAO().save(photo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistré avec succès", ""));
    }

    private void updatePhoto() {
        photoDAO().update(photo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée avec succès", ""));
    }

    public String deletePhoto() {
        photoDAO().remove(photo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement supprimé avec succès", ""));
        return null;
    }
     
    public void upload() {
        System.out.println("voilaaaaaaaaaaaaaaaa");
        if(file != null) {
            try {
                InputStream inputStream = file.getInputstream();
                Photo photo = new Photo();
                savePhoto(photo, inputStream);
                insertPhoto();
                FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } catch (IOException ex) {
                ex.printStackTrace();
                FacesMessage message = new FacesMessage("There was a problem, your file wasn't uploaded");
                FacesContext.getCurrentInstance().addMessage(null, message);
//                Logger.getLogger(UtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public List<Photo> getPhotoList() {
        photoList = photoDAO().getEntities();
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
    
     
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public void savePhoto(Photo photo, InputStream inputStream) throws IOException{
        File files = new File("image.jpg");
        photoDAO().saveFile(inputStream, files);
    }
    
}
