/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Password;
import Main.Main;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author minkyaw
 */
public class LoginControl {
    public LoginControl() {
        
    }
    
    public void setPwd(String password) {
        Main.em.getTransaction().begin();
        Password pwd = new Password();
        pwd.setPassword(password);
        
        Main.em.persist(pwd);
        Main.em.getTransaction().commit();
        
    }
    
    public boolean checkPassword(String pwd){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("select password from PASSWORD");
        List lst  = qu1.getResultList();
        Main.em.getTransaction().commit();
        if (pwd.equals(lst.get(0))){
            return true;
        }
        else {
            return false;
        }
    }
    
}
