/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Product;
import Entity.ProductPK;
import Entity.Producttitle;
import Entity.Warehouse;
import Main.Main;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductControl {
    
    public void createProduct(String productName, String warehouseName, int quantity){
        EntityManagerFactory productFactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager productManager = productFactory.createEntityManager( );
        productManager.getTransaction().begin();
        
        ProductPK productPK = new ProductPK();
        productPK.setProductname(productName);
        productPK.setWarehousename(warehouseName);
        
        Product product = new Product();
        product.setQuantity(quantity);
        product.setProductPK(productPK);
        
        Warehouse warehouse = productManager.find(Warehouse.class, warehouseName);
        
        product.setWarehouse(warehouse);
        
        productManager.getTransaction().commit();
    }
    
    public List<Product> getProductResultSet(){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT ProductName, SUM(Quantity) FROM Product"
                + " GROUP BY ProductName");
        List<Product> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
    
    public List<Producttitle> getProductTitleResultSet(){
        Main.em.getTransaction().begin();
        Query qu1 = Main.em.createNativeQuery("SELECT SellingPrice, CostPrice FROM Product");
        List<Producttitle> lst = qu1.getResultList();
        Main.em.getTransaction().commit();
        return lst;
    }
}
