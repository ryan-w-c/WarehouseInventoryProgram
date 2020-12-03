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
    
    public List<Object[]> getProductResultSet(){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT p.productname, p.sellingprice, p.costprice, SUM(p.quantity), coalesce(SUM(o.quantity), 0), coalesce(SUM(o.quantity) * (p.sellingprice - p.costprice) / (SUM(o.quantity) * p.sellingprice) * 100, 0) as profpercent from product p left outer join orderitem o on p.productname = o.productname group by p.productname, p.sellingprice, p.costprice order by profpercent desc");
        List<Object[]> lst = qu1.getResultList();
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
    
    public void updateQuantityOrder(String p, String w, Integer q) {
        Product p1 = getProduct(p, w);
        Main.em.getTransaction().begin();
        p1.updateQuantity(q);
        Main.em.persist(p1);
        Main.em.getTransaction().commit();
    }
    
    
}
