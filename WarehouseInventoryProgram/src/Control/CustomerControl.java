/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Main.WarehouseInventory;
import Entity.Customer;
import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author minkyaw
 */
public class CustomerControl {
   
    public void addCustomer(Integer customerid, String firstname, String lastname, String phone, String email, String address, String city, String state, int zip) {
        WarehouseInventory.em.getTransaction().begin();
        Customer c1 = new Customer();
        
        c1.setCustomerid(customerid);
        c1.setFirstname(firstname);
        c1.setLastname(lastname);
        c1.setPhone(phone);
        c1.setEmail(email);
        c1.setAddress(address);
        c1.setCity(city);
        c1.setState(state);
        c1.setZip(zip);
        
        WarehouseInventory.em.persist(c1);
        WarehouseInventory.em.getTransaction().commit();
    }
    
    public void editCustomer(Integer customerid, String firstname, String lastname, String phone, String email, String address, String city, String state, int zip) {
        WarehouseInventory.em.getTransaction().begin();
        Customer c1 = new Customer();
        
        c1.setCustomerid(customerid);
        c1.setFirstname(firstname);
        c1.setLastname(lastname);
        c1.setPhone(phone);
        c1.setEmail(email);
        c1.setAddress(address);
        c1.setCity(city);
        c1.setState(state);
        c1.setZip(zip);
        
        WarehouseInventory.em.persist(c1);
        WarehouseInventory.em.getTransaction().commit();
    }
    
}
