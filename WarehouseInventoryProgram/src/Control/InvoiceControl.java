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
import Entity.OrderitemPK;
import Entity.Product;
import Entity.ProductPK;
import Entity.Salesperson;
import Main.Main;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;

public final class InvoiceControl {
    private int id;
    public InvoiceControl(){
        id = getNewID();
    }
    public void addInvoice(Salesperson sp,Customer customer, double subTotal,
        double tax, double comm, double deliveryfee,double total, double balance, 
        boolean openClose, String time,Collection<Orderitem> items, int id1){
        
        Main.em.getTransaction( ).begin( );

        Invoice inv1 = new Invoice(); 
        inv1.setInvoiceid( id1);
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

        Main.em.persist( inv1 );
        Main.em.getTransaction( ).commit( );

    }
    
    public List<Invoice> getOpenInvoiceResultSet(){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT * FROM INVOICE where OPENCLOSE = true", Invoice.class);
        List<Invoice> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    
    public List<Invoice> getCloseInvoiceResultSet(){
        Main.em.getTransaction().begin();    
        Query qu1 = Main.em.createNativeQuery("SELECT * FROM INVOICE where OPENCLOSE = false", Invoice.class);
        List<Invoice> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
       
       
    public Integer getNewID (){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("select max(SALESPERSONID) from SALESPERSON");
        List lst  = qu1.getResultList();
        Main.em.getTransaction().commit();
        Integer ans;
        if (lst.get(0) == null) {
            ans = 1;
        } else {
            ans = Integer.parseInt(lst.get(0).toString()) +1;
        } 
        return ans;
    }
        
    public int getInvoiceID(){
        return id++;
    }
        
        
    public Orderitem addOrderItem(int invID, String pn, String wn, int quantity){

        Main.em.getTransaction( ).begin( );

        Orderitem oi = new Orderitem(invID, pn, wn,quantity ); 

        Main.em.persist( oi );
        Main.em.getTransaction( ).commit( );
        return oi;
    }
         
         
    public void removeQuantityinDB(Orderitem od){
        OrderitemPK odpk = od.getOrderitemPK();
        String prodname  = odpk.getProductname();
        String wn = odpk.getWarehousename();

        Main.em.getTransaction( ).begin( );
        Query sqll = Main.em.createNativeQuery("select Sum(QUANTITY) from PRODUCT where PRODUCTNAME ="+
                "'"+ prodname +"'" + "and WAREHOUSENAME = "+ "'" + wn + "'");
        List lst = sqll.getResultList();
        Integer ans = Integer.parseInt(lst.get(0).toString()) - od.getQuantity();

        ProductPK ppk = new ProductPK(prodname,wn);
        Product p1 = Main.em.find(Product.class, ppk);
        p1.setQuantity(ans);

        Main.em.persist( p1 );
        Main.em.getTransaction( ).commit( );
    }
   
    
    
    
}
