/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Product;
import Entity.ProductPK;
import Entity.Warehouse;
import Main.Main;
import java.util.List;
import javax.persistence.Query;

public class ProductControl {
    
    public void createProduct(String productName, String warehouseName, double sellingPrice, double costPrice){
        Main.em.getTransaction().begin();
        
        ProductPK productPK = new ProductPK();
        productPK.setProductname(productName);
        productPK.setWarehousename(warehouseName);
        
        Product p = new Product();
        p.setQuantity(0);
        p.setProductPK(productPK);
        p.setCostprice(costPrice);
        p.setSellingprice(sellingPrice);
        Warehouse w = Main.em.find(Warehouse.class, warehouseName);
        
        p.setWarehouse(w);
        
        Main.em.persist(p);
        Main.em.getTransaction().commit();
    }
    
    public List<Product> getSingleProductResultSet(String p){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNamedQuery("Product.findByProductname");
        qu1.setParameter("productname", p);
        List<Product> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public List<List<String>> getProductResultSet(){
        Main.em.getTransaction().begin();
        //FIXME query maybe have to use views?? see: https://stackoverflow.com/questions/30275317/cannot-be-cast-to-ljava-lang-object?rq=1 
        //or maybe a named query like above
        Query qu1 = Main.em.createNativeQuery("SELECT p.productname, p.sellingprice, p.costprice, SUM(p.quantity) as totalquantity, SUM(o.quantity) as quantitysold, SUM(o.quantity) * p.sellingprice as totalsales, SUM(o.quantity) * p.costprice as totalcost, SUM(o.quantity) * p.sellingprice - p.costprice as profit, profit / totalsales * 100 FROM Product p inner join ORDERITEM o on p.productname = o.productname group by productname, sellingprice, costprice order by desc profpercent");
        List<List<String>> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public void addProduct(String pName, double sellingPrice, double costPrice){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT warehousename FROM Warehouse");
        List<String> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        for (int i = 0; i < lst.size(); i++) {
            createProduct(pName, lst.get(i), sellingPrice, costPrice);
        }
    }
    
    public List<String> getDistinctProductResultSet(){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT distinct productname FROM product");
        List<String> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public List<Product> getLowProductResultSet(Warehouse w) {
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNamedQuery("Product.findByWarehousenameLow");
        qu1.setParameter("warehousename", w.getWarehousename());
        List<Product> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public List<Product> getAllProductResultSet(Warehouse w) {
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNamedQuery("Product.findByWarehousename");
        qu1.setParameter("warehousename", w.getWarehousename());
        List<Product> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public Product getProduct(String p, String w) {
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNamedQuery("Product.findByPK");
        qu1.setParameter("productname", p);
        qu1.setParameter("warehousename", w);
        List<Product> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst.get(0);
    }
    
    public void updateQuantity(String p, String w, Integer q) {
        Product p1 = getProduct(p, w);
        Main.em.getTransaction().begin();
        p1.setQuantity(q);
        Main.em.persist(p1);
        Main.em.getTransaction().commit();
    }
    
}
