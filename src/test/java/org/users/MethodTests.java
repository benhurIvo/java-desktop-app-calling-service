/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.users;

import java.util.HashMap;
import org.domain.RegPerson;
import org.junit.Test;
import org.users.impl.UserManagerImpl;
import static org.junit.Assert.assertEquals;
import org.util.MyUtils;

/**
 *
 * @author benhur
 */
public class MethodTests {
    
    @Test
    public void addUserInfoTest(){
                    
        UserManagerImpl ui = new UserManagerImpl();
        assertEquals(Boolean.TRUE, ui.addUserInfo("ivan", "ivo"));
    }
    
    @Test
    public void updateUserInfoTest(){
                    
        UserManagerImpl ui = new UserManagerImpl();

        ui.addUserInfo("ivan", "ivo");        
            HashMap<Integer, RegPerson> people = MyUtils.getPeopleMap();
            RegPerson st = people.get(people.keySet().toArray()[0]);
        assertEquals(Boolean.TRUE, ui.updateUserInfo("ivan", "prog",Integer.parseInt(st.getId())));
    }
    
    @Test
    public void deleteUserInfoTest(){
                    
        UserManagerImpl ui = new UserManagerImpl();

        ui.addUserInfo("benh", "benh");        
            HashMap<Integer, RegPerson> people = MyUtils.getPeopleMap();
            RegPerson st = people.get(people.keySet().toArray()[0]);
            System.out.println("iddd "+st.getId());
        assertEquals(Boolean.TRUE, ui.deleteUserInfo(Integer.parseInt(st.getId())));
    }
    
}
