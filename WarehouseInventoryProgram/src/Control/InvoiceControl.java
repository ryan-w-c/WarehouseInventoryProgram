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
import Entity.Invoice;
import Entity.Orderitem;
import Entity.Salesperson;
import Main.Main;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;

public class InvoiceControl {
    
    public void addInvoice(Integer sp,Object customer, Integer id, double subTotal,
            double tax, double comm, double deliveryfee,double total, double balance, 
            boolean openClose, String time,Collection<Orderitem> items){
        
      Main.em.getTransaction( ).begin( );

      Invoice inv1 = new Invoice(); 
      inv1.setInvoiceid( id );
      inv1.setSubtotal( subTotal);
      inv1.setTax( tax );
      inv1.setCommission( comm );
      inv1.setDeliverfee(deliveryfee);
      inv1.setTotal(total);
      inv1.setBalanceremaining(balance);
      inv1.setOpenclose(openClose);
      inv1.setDatetime(time);
      inv1.setOrderitemCollection(items);
//      inv1.setCustomerid(customer);  
//      inv1.setSalespersonid(sp);
      
      Main.em.persist( inv1 );
      Main.em.getTransaction( ).commit( );

      Main.em.close( );
    }
    
        public List<Invoice> getSalespersonResultSet(){
  
        Main.em.getTransaction().begin();
       
        Query qu1 = Main.em.createNativeQuery("select * from INVOICE", Invoice.class);
        List<Invoice> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    
    
}
