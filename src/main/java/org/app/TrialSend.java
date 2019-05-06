///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.app;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import org.domain.Person;
//import org.domain.RegPerson;
//import org.users.impl.UserManagerImpl;
//import org.util.MyUtils;
//
///**
// *
// * @author benhur
// */
//public class TrialSend {
//    public static void main(String[] args) throws JsonProcessingException {
////        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
////        
////        Person p = new Person();
////        p.setName("ivo");
////        p.setJob("prog");
////String json = ow.writeValueAsString(p);
////        
////UserManagerImpl ui = new UserManagerImpl();
////
////        System.out.println( ui.addUserInfo("ivan", "ivo"));
////        System.out.println( ui.addUserInfo("kay", "inb"));
//        
//
//UserManagerImpl ui = new UserManagerImpl();
//
//        ui.addUserInfo("benh", "benh");        
//            HashMap<Integer, RegPerson> people = MyUtils.getPeopleMap();
//            RegPerson st = people.get(people.keySet().toArray()[0]);
//            System.out.println("iddd "+ui.deleteUserInfo(Integer.parseInt(st.getId())));
//            printMap(people);
//            
//    }
//    
//    
//    public static void printMap(Map mp) {
//    Iterator it = mp.entrySet().iterator();
//    while (it.hasNext()) {
//        Map.Entry pair = (Map.Entry)it.next();
//        System.out.println(pair.getKey() + " = " + pair.getValue());
//        it.remove(); // avoids a ConcurrentModificationException
//    }
//}
//}
