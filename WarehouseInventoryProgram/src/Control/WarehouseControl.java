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
    
    private void addWarehouse (){
        
        WarehouseInventory.em.getTransaction().begin();
        Warehouse w1 = new Warehouse(); 
        w1.setWarehousename("WarehouseName");

        
        WarehouseInventory.em.persist(w1);
        WarehouseInventory.em.getTransaction().commit();

    }    

}
