/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nanda
 */
@WebService(serviceName = "Ex12WebService")
public class Ex12WebService {
    
    Connection con;
    
    public Ex12WebService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ex12WebService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ex12WebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "recordReview")
    public String recordReview(@WebParam(name = "name") String name, @WebParam(name = "age") int age, @WebParam(name = "rating") int rating, @WebParam(name = "review") String review) {
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO reviews VALUES('" + name + "', '" + String.valueOf(age) + "', '" + String.valueOf(rating) + "', '" + review + "');");
        } catch (SQLException ex) {
            Logger.getLogger(Ex12WebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "OK";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showReview")
    public String showReview() {
        String reviews = "";
        Statement st; ResultSet rs; int i = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM reviews");
            while (rs.next()) {
                i++;
                reviews += String.valueOf(i) + ". Name: " + rs.getString("name") + " Age: " + rs.getString("age") + " Rating: " + rs.getString("rating") + "\n   Review: " + rs.getString("review") + "\n\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ex12WebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviews;
    }
}
