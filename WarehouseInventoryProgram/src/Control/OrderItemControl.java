/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Orderitem;
import Entity.OrderitemPK;
import Entity.Invoice;
import Main.Main;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author minkyaw
 */
public class OrderItemControl {
    
    public void createOrderItem(int invoiceID, String productName, String warehouseName, int quantity) {
        Main.em.getTransaction().begin();
        
        OrderitemPK orderitemPK = new OrderitemPK();
        orderitemPK.setInvoiceid(invoiceID);
        orderitemPK.setProductname(productName);
        orderitemPK.setWarehousename(warehouseName);
        
        Orderitem o = new Orderitem();
        o.setQuantity(0);
        o.setOrderitemPK(orderitemPK);
        Invoice i = Main.em.find(Invoice.class, invoiceID);
        
        o.setInvoice(i);
        
        Main.em.persist(o);
        Main.em.getTransaction().commit();
        
    }
    
    public List<Orderitem> getAllOrderItemResultSet(int id) {
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNamedQuery("Orderitem.findByInvoiceid");
        qu1.setParameter("invoiceid", id);
        List<Orderitem> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public Orderitem getOrderitem(int i, String p, String w) {
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNamedQuery("Orderitem.findByPK");
        qu1.setParameter("invoiceid", i);
        qu1.setParameter("productname", p);
        qu1.setParameter("warehousename", w);
        List<Orderitem> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst.get(0);
    }
    
    public void updateQuantity(int i, String p, String w, Integer q) {
        Orderitem o1 = getOrderitem(i, p, w);
        Main.em.getTransaction().begin();
        o1.setQuantity(q);
        Main.em.persist(o1);
        Main.em.getTransaction().commit();
    }
    
}
