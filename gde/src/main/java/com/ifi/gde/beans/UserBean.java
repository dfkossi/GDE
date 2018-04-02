/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.beans;

import com.ifi.gde.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;

import com.ifi.gde.service.UserService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import com.sun.faces.util.MessageUtils;
import javax.faces.application.FacesMessage;
/**
 *
 * @author peniel
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    @ManagedProperty(value = "#{userService}")
    UserService userService;
    private String name;
    private String surname;
    public List<User> users = new ArrayList<User>();
    public User userCtl = new User();
    HtmlForm formulaire;
    HtmlCommandButton maj;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUserCtl() {
        return userCtl;
    }

    public void setUserCtl(User userCtl) {
        this.userCtl = userCtl;
    }
// method CRUD

    public String persistUser() {
        userService.persistUser(this.userCtl);
        return "index";
    }

    public List<User> listUsers() {
        return this.userService.listUsers();
    }

    public void deleteUser(int id) {
        User user = (User) userService.findUserById(id);
        getUserService().deleteUser(user);
    }

    public String editUser(User userCtl) {
        this.userCtl = userCtl;
        return "update";
    }

    public String updateUser() {
        getUserService().updateUser(userCtl);
        return "index";
    }

    public String showUser(User userCtl) {
        this.userCtl = userCtl;
        return "show";
    }
}