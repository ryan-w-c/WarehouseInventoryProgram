/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Salesperson;

import java.util.List;
//import javax.persistence.EntityManager;
import javax.persistence.Query;
import Main.WarehouseInventory;


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
        
        
        WarehouseInventory.em.getTransaction().begin();
        Salesperson employee = new Salesperson(); 
        employee.setFirstname(fname);
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
        
        WarehouseInventory.em.persist(employee);
        WarehouseInventory.em.getTransaction().commit();//Rutvi
//        WarehouseInventory.em.close();
    }

    public List<Salesperson> getSalespersonResultSet(){
  

        WarehouseInventory.em.getTransaction().begin();
       
        Query qu1 = WarehouseInventory.em.createNativeQuery("select SALESPERSONID, FIRSTNAME, LASTNAME, PHONE from SALESPERSON", Salesperson.class);
        List<Salesperson> lst = qu1.getResultList();
        WarehouseInventory.em.getTransaction().commit();
        return lst;
      }
    
   public Integer getNewID (){
       WarehouseInventory.em.getTransaction().begin();
        Query qu1 = WarehouseInventory.em.createNativeQuery("select max(SALESPERSONID) from SALESPERSON");
        List lst  = qu1.getResultList();
        WarehouseInventory.em.getTransaction().commit();
        Integer ans;
        if (lst.get(0) == null){
            ans = 1;
        }else {
        ans = Integer.parseInt(lst.get(0).toString()) +1;
   } 
        return ans;
}
}