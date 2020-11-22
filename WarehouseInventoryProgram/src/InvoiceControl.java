/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zubin
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entity.Invoice;

public class InvoiceControl {
    
    public void addInvoice(){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager();
      entitymanager.getTransaction( ).begin( );

      Invoice inv1 = new Invoice( ); 
      inv1.setInvoiceid( 1 );
      inv1.setSubtotal( 12.5 );
      inv1.setTax( 4.7 );
      inv1.setCommission( 45 );
      inv1.setDeliverfee(4.86);
      
      
      entitymanager.persist( inv1 );
      entitymanager.getTransaction( ).commit( );

      entitymanager.close( );
      emfactory.close( );
    }
    
    
}
