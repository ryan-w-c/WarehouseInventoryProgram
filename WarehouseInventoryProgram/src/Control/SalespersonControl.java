/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Salesperson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author zubin
 */
public class SalespersonControl {
    EntityManager entitymanager;

    public SalespersonControl (EntityManager em){
        entitymanager = em;
    }
    
    
    public void addSalesperson (){
        
        entitymanager.getTransaction().begin();
        Salesperson employee = new Salesperson(); 
        employee.setFristname("Ryan");
        employee.setLastname( "C" );
        employee.setAddress("12345 street");
        employee.setCity("city");
        employee.setEmail("myemail");
        employee.setState("CA");
        employee.setCommissionrate(.5);
        employee.setPhone("phone");
        employee.setSalespersonid(122);
        employee.setZip(90000);
        employee.setTotalsales(0.0);
        employee.setTotalcommission(0.0);
        
        entitymanager.persist(employee);
        entitymanager.getTransaction().commit();

        entitymanager.close();
//        emfactory.close();
    }
    
}
