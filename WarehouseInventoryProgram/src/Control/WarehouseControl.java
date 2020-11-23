/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Main.WarehouseInventory;
import Entity.Warehouse;

/**
 *
 * @author ryancavanagh
 */
public class WarehouseControl {
    
    
    public WarehouseControl (){}
    
    public void addWarehouse (String wName, String address, String city, String state, Integer zip, String phone){
        
        WarehouseInventory.em.getTransaction().begin();
        Warehouse w1 = new Warehouse(); 
        
        w1.setWarehousename(wName);
        w1.setAddress(address);
        w1.setCity(city);
        w1.setState(state);
        w1.setZipcode(zip);
        w1.setPhone(phone);
        
        WarehouseInventory.em.persist(w1);
        WarehouseInventory.em.getTransaction().commit();

    }
    
//    public editWarehouse(){
//        w1.setWarehousename("WarehouseName");
//        w1.setAddress(address);
//        w1.setCity(city);
//        w1.setState(state);
//        w1.setZipcode(zip);
//        w1.setPhone(phone);
//        
//    }

}
