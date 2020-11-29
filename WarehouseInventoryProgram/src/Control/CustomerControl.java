/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Main.Main;
import Entity.Customer;
import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author minkyaw
 */

public class CustomerControl {
    
    private int idNum;
    
    public CustomerControl (){
        idNum = getNewID();

    }
   
    public void addCustomer(String firstname, String lastname, String phone, String email, String address, String city, String state, int zip) {
        Main.em.getTransaction().begin();
        Customer c1 = new Customer();
        
        c1.setFirstname(firstname);
        c1.setLastname(lastname);
        c1.setPhone(phone);
        c1.setEmail(email);
        c1.setAddress(address);
        c1.setCity(city);
        c1.setState(state);
        c1.setZip(zip);
        
        Main.em.persist(c1);
        Main.em.getTransaction().commit();
    }
    
    public void saveCustomer(Customer c) {
        Main.em.getTransaction().begin();
        Main.em.persist(c);
        Main.em.getTransaction().commit();
    }
    
       

    public List<Customer> getCustomerResultSet(){
        Main.em.getTransaction().begin();
       
        Query qu1 = Main.em.createNativeQuery("select * from CUSTOMER", Customer.class);
        List<Customer> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
      }
    
    public Integer getNewID (){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("select max(CUSTOMERID) from CUSTOMER");
        List lst  = qu1.getResultList();
        Main.em.getTransaction().commit();
        Integer ans;
        if (lst.get(0) == null) {
            ans = 1;
        } else {
            ans = Integer.parseInt(lst.get(0).toString()) +1;
        } 
        return ans;
    }
    
}
