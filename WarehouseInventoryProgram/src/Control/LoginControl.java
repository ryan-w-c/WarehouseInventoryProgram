/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Password;
import Main.WarehouseInventory;

/**
 *
 * @author minkyaw
 */
public class LoginControl {
    public LoginControl() {
        
    }
    
    public void setPwd(String password) {
        WarehouseInventory.em.getTransaction().begin();
        Password pwd = new Password();
        pwd.setPassword(password);
        
        WarehouseInventory.em.persist(pwd);
        WarehouseInventory.em.getTransaction().commit();
        
    }
}
