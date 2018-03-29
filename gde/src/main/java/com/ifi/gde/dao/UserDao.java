/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifi.gde.dao;

import com.ifi.gde.model.User;
import java.util.List;

/**
 *
 * @author peniel
 */
public interface UserDao {

    void persistUser(User user);

    User findUserById(int id);

    void updateUser(User user);

    void deleteUser(User user);

    public List<User> listUsers();
}
