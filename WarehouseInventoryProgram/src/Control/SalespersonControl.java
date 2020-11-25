/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Salesperson;
import Main.Main;
import static Main.Main.emfactory;
import static Main.Main.em;
import java.util.List;
//import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Main.Main;
import Main.Main;


/**
 *
 * @author zubin
 */
public class SalespersonControl {

    public SalespersonControl (){
        
    }
    
    
    public void addSalesperson (String fname,String lname, String address, 
            String city, String email, String state , double Crate, String phone,
            int id, int zip, double sales, double commission  ){
        
        Main.em.getTransaction().begin();
        Salesperson employee = new Salesperson(); 
        employee.setFristname(fname);
        employee.setLastname( lname );
        employee.setAddress(address);
        employee.setCity(city);
        employee.setEmail(email);
        employee.setState(state);
        employee.setCommissionrate(Crate);
        employee.setPhone(phone);
        employee.setSalespersonid(id);
        employee.setZip(90000);
        employee.setTotalsales(0.0);
        employee.setTotalcommission(0.0);
        
        Main.em.persist(employee);
        Main.em.getTransaction().commit();

        Main.em.close();
        
    }

    public List<Salesperson> getSalespersonResultSet(){
  
//        emfactory = Persistence.createEntityManagerFactory("WarehouseInventoryProgramPU");
//        em = emfactory.createEntityManager();
//        
//        EntityManager em = WarehouseInventory.em;

        Main.em.getTransaction().begin();
       
        Query qu1 = Main.em.createNativeQuery("select SALESPERSONID, FRISTNAME, LASTNAME, PHONE from SALESPERSON", Salesperson.class);
        List<Salesperson> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
      }
    
}
