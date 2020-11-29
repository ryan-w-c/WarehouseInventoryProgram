package Main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Control.ControlFactory;
import boundary.Login;
import boundary.SelectCustomer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryancavanagh
 */


public class Main {
    
    public static EntityManager em;
    public static EntityManagerFactory emfactory;
    public static ControlFactory controlfactory;
    
    public static void main(String[] args) {
        new Login().setVisible(true);
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WarehouseInventoryProgramPU");
        em = emfactory.createEntityManager();
        controlfactory = new ControlFactory();
        
//        SelectCustomer sc = new SelectCustomer();
//        System.out.println(sc.jButton2ActionPerformed());
    }
      
}