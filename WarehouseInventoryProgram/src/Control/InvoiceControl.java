package Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zubin
 */

import Entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entity.Invoice;
import Entity.Salesperson;

public class InvoiceControl {
    
    public void addInvoice(Salesperson sp,Customer c1){
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
      entitymanager.getTransaction( ).begin( );

      Invoice inv1 = new Invoice(); 
      inv1.setInvoiceid( 1 );
      inv1.setSubtotal( 12.5 );
      inv1.setTax( 4.7 );
      inv1.setCommission( 45 );
      inv1.setDeliverfee(4.86);
      inv1.setTotal(34.6);
      inv1.setBalanceremaining(2.6);
      inv1.setOpenclose(true);
      inv1.setDatetime("12/3/2021");
//      setOrderitemCollection();
      inv1.setCustomerid(c1);  
      inv1.setSalespersonid(sp);
      
      entitymanager.persist( inv1 );
      entitymanager.getTransaction( ).commit( );

      entitymanager.close( );
      emfactory.close( );
    }
    
    
}
