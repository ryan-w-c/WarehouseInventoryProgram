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
import Main.WarehouseInventory;
import java.util.Collection;

public class InvoiceControl {
    
    public void addInvoice(Salesperson sp,Customer customer, Integer id, double subTotal,
            double tax, double comm, double deliveryfee,double total, double balance, 
            boolean openClose, String time,Collection<Orderitem> items){
        
      WarehouseInventory.em.getTransaction( ).begin( );

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
      inv1.setCustomerid(customer);  
      inv1.setSalespersonid(sp);
      
      WarehouseInventory.em.persist( inv1 );
      WarehouseInventory.em.getTransaction( ).commit( );

      WarehouseInventory.em.close( );
    }
    
    
}
