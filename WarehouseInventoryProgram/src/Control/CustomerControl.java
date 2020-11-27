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
public final class CustomerControl {
    int id;
    public CustomerControl () {

    }
    
   
    public void addCustomer(Integer customerid, String firstname, String lastname, String phone, String email, String address, String city, String state, int zip) {
        Main.em.getTransaction().begin();
        Customer c1 = new Customer();
        
        c1.setCustomerid(id++);
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
       
        Query qu1 = Main.em.createNativeQuery("select SALESPERSONID, FIRSTNAME, LASTNAME, PHONE from SALESPERSON", Customer.class);
        List<Customer> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
      }
       
    
}
