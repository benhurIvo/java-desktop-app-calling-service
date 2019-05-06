/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.domain.RegPerson;

/**
 *
 * @author benhur
 */
public class MyUtils {
    static String data = "";
    final static String USER_AGENT = "Mozilla/5.0";
    public static HashMap<Integer, RegPerson> people = new HashMap<Integer, RegPerson>();
    
    public static HashMap<Integer, RegPerson> getPeopleMap() {
         return people;
    }
    
    public static HashMap<Integer, RegPerson> addPeopleMap(int id,RegPerson rg) {
            people.put(id, rg);
         return people;
    }
    
    
    public static HashMap<Integer, RegPerson> delPerson(int id) {
            people.remove(id);
         return people;
    }
    
    
    public static Object[][] hashMapTo2D(HashMap map) {
Object[][] arr = new Object[map.size()][3];
Set entries = map.entrySet();
Iterator entriesIterator = entries.iterator();

int i = 0;
while(entriesIterator.hasNext()){

    Map.Entry mapping = (Map.Entry) entriesIterator.next();

    arr[i][0] = mapping.getKey();
    RegPerson rg = (RegPerson)mapping.getValue();
    arr[i][1] = rg.getName()+ "  ---  "+rg.getJob();

    i++;
}

return arr;
    }
    
    public static String sendurl(String target, String mtd, String input){
	try {
		    

			URL targetUrl = new URL(target);

			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setDoOutput(true);
                        httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded" );
			httpConnection.setRequestMethod(mtd);
                        httpConnection.setRequestProperty("User-Agent", USER_AGENT);
			
			if(mtd.equals("POST")||mtd.equals("PUT")){
			httpConnection.setRequestProperty("Content-Type", "application/json");
			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();
			}
//			if (httpConnection.getResponseCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//					+ httpConnection.getResponseCode());
//			}

			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
					(httpConnection.getInputStream())));

			String output="";
			System.out.println("Output from Server:\n");
			
			while ((output = responseBuffer.readLine()) != null) {
				data = output;
			}
	    System.out.println("datas "+data);
			httpConnection.disconnect();
			

		  } catch (Exception e) {

			e.printStackTrace();

		  } 
	return data;
}
    
    public static String del(String target){
        try {
            URL url = new URL(target);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestProperty(
                    "Content-Type", "application/x-www-form-urlencoded" );
            httpCon.setRequestMethod("DELETE");
            httpCon.setRequestProperty("User-Agent", USER_AGENT);
            httpCon.connect();
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
					(httpCon.getInputStream())));

			String output="";
			System.out.println("Output from Server:\n");
			
			while ((output = responseBuffer.readLine()) != null) {
				data = output;
			}
	    System.out.println("datas "+data);
			httpCon.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(MyUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
