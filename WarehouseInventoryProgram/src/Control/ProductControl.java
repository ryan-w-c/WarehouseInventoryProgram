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
    
    public List<Product> getProductResultSet(){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT ProductName, SUM(Quantity) FROM Product"
                + " GROUP BY ProductName");
        List<Product> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
//    public List<Producttitle> getProductTitleResultSet(){
//        Main.em.getTransaction().begin();
//        Query qu1 = Main.em.createNativeQuery("SELECT SellingPrice, CostPrice FROM Product");
//        List<Producttitle> lst = qu1.getResultList();
//        Main.em.getTransaction().commit();
//        return lst;
//    }
    
    public void addProduct(String pName, double sellingPrice, double costPrice){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT warehousename FROM Warehouse");
        List<String> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
            createProduct(pName, lst.get(i), sellingPrice, costPrice);
        }
        
        
    }
    
}
