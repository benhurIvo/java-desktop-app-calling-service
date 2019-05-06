/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.users.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.domain.Person;
import org.domain.RegPerson;
import org.users.UserManager;
import org.util.MyUtils;

/**
 *
 * @author benhur
 */
public class UserManagerImpl implements UserManager{
    
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    ObjectMapper mapper = new ObjectMapper();
    final String targetURL = "https://reqres.in/api/users";

    public boolean addUserInfo(String userName, String job) {
        Person p = new Person();
        String obj = "";
        p.setName(userName);
        p.setJob(job);
        try {
            obj = ow.writeValueAsString(p);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String resp = MyUtils.sendurl(targetURL,"POST",obj);
        
        if(resp.contains("id")){
            RegPerson rp = new RegPerson();
            
            try {
                rp = mapper.readValue(resp, RegPerson.class);
            } catch (IOException ex) {
                Logger.getLogger(UserManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            MyUtils.addPeopleMap(Integer.parseInt(rp.getId()), rp);
            return true;
        }
        else
            return false;
        
        }

    public boolean updateUserInfo(String userName, String job, int id) {
    
    Person p = new Person();
        String obj = "";
        p.setName(userName);
        p.setJob(job);
        try {
            obj = ow.writeValueAsString(p);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String resp = MyUtils.sendurl(targetURL+"/"+String.valueOf(id),"PUT",obj);
        
        if(resp.contains(userName)){
            RegPerson rp = new RegPerson();
            
            try {
                rp = mapper.readValue(resp, RegPerson.class);
                rp.setId(String.valueOf(id));
            } catch (IOException ex) {
                Logger.getLogger(UserManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            MyUtils.addPeopleMap(id, rp);
            return true;
        }
        else
            return false;
    
    }

    public boolean deleteUserInfo(int id) {
    
    String resp = MyUtils.sendurl(targetURL+"/"+String.valueOf(id),"DELETE","");
    
        System.out.println("deleted "+resp);
    
        if(resp.contains(String.valueOf(id))){
             MyUtils.delPerson(id);
        return true;
        }
        else
            return false;
    
    }
    
}
