/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Salesperson;
import Main.WarehouseInventory;
import static Main.WarehouseInventory.emfactory;
import static Main.WarehouseInventory.em;
import java.util.List;
//import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



/**
 *
 * @author zubin
 */
public class SalespersonControl {

    public SalespersonControl (){
        
    }
    
    
    public void addSalesperson (){
        
        WarehouseInventory.em.getTransaction().begin();
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
        
        WarehouseInventory.em.persist(employee);
        WarehouseInventory.em.getTransaction().commit();

        WarehouseInventory.em.close();
        
    }

    public List<Salesperson> getSalespersonResultSet(){
  
        emfactory = Persistence.createEntityManagerFactory("WarehouseInventoryProgramPU");
        em = emfactory.createEntityManager();

//        EntityManager em = WarehouseInventory.em;

        em.getTransaction().begin();
       
        Query qu1 = em.createNativeQuery("select SALESPERSONID, FRISTNAME, LASTNAME, PHONE from SALESPERSON", Salesperson.class);
        List<Salesperson> lst = qu1.getResultList();
        em.getTransaction().commit();
        return lst;
      }
    
}
