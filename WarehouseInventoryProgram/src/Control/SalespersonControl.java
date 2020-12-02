/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Salesperson;
import java.util.List;
import javax.persistence.Query;
import Main.Main;


/**
 *
 * @author zubin
 */
public final class SalespersonControl {
    
    private int idNum;
    
    public SalespersonControl (){
        idNum = getNewID();
    }
    
    public void addSalesperson (String fname, String lname, String address, 
            String city, String email, String state , double Crate, String phone,
            int zip, double sales, double commission){
        
        Main.em.getTransaction().begin();
        Salesperson employee = new Salesperson(); 
        employee.setFirstname(fname);
        employee.setLastname(lname);
        employee.setAddress(address);
        employee.setCity(city);
        employee.setEmail(email);
        employee.setState(state);
        employee.setCommissionrate(Crate);
        employee.setPhone(phone);
        employee.setActive(true);
        employee.setSalespersonid(idNum++);
        employee.setZip(zip);
        employee.setTotalsales(0.0);
        employee.setTotalcommission(0.0);
        
        Main.em.persist(employee);
        Main.em.getTransaction().commit();
    }

    public List<Salesperson> getSalespersonResultSet(){
  
        Main.em.getTransaction().begin();
       
        Query qu1 = Main.em.createNativeQuery("select * from SALESPERSON", Salesperson.class);
        List<Salesperson> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public List<Salesperson> getActiveSalespersonResultSet(){
        Main.em.getTransaction().begin();
       
        Query qu1 = Main.em.createNamedQuery("Salesperson.findByActive");
        qu1.setParameter("active", true);
        List<Salesperson> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }

    public void saveSalesperson(Salesperson s) {
        Main.em.getTransaction().begin();
        Main.em.persist(s);
        Main.em.getTransaction().commit();
    }
    
   public Integer getNewID (){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("select max(SALESPERSONID) from SALESPERSON");
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