/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Product;
import Main.Main;
import Entity.Warehouse;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ryancavanagh
 */
public class WarehouseControl {
  
    
    public WarehouseControl (){
    }
    
    public void addWarehouse (String wName, String address, String city, String state, Integer zip, String phone){
        
        Main.em.getTransaction().begin();
        Warehouse w1 = new Warehouse(); 
        
        w1.setWarehousename(wName);
        w1.setAddress(address);
        w1.setCity(city);
        w1.setState(state);
        w1.setZipcode(zip);
        w1.setPhone(phone);
        
        Main.em.persist(w1);
        Main.em.getTransaction().commit();
        
        updateProducts(wName);

    }
    
    public void updateProducts(String w){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT distinct productname, sellingprice, costprice FROM Product");
        List<Object[]> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        ProductControl pc = Main.controlfactory.getProduct();
        for (int i = 0; i < lst.size(); i++) {
            pc.createProduct(lst.get(i)[0].toString(), w, Double.parseDouble(lst.get(i)[1].toString()), Double.parseDouble(lst.get(i)[2].toString()));
        }
    }
    
    public List<Warehouse> getWarehouseResultSet(){

        Main.em.getTransaction().begin();
       
        Query qu1 = Main.em.createNativeQuery("select * from Warehouse", Warehouse.class);
        List<Warehouse> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
}
