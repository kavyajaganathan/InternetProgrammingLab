
import webservices.Ex12WebService;
import webservices.Ex12WebService_Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nanda
 */
public class JavaWebApplicationClient {
    public static void main(String[] args) {
        Ex12WebService_Service service = new Ex12WebService_Service();
        final Ex12WebService port = service.getEx12WebServicePort();
        // OK is returned, values are added to the database
        System.out.println(port.recordReview("Nanda", 20, 10, "Great!"));
        // Returns all rows in the database
        System.out.println(port.showReview());
    }
}
