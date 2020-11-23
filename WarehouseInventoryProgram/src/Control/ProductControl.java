/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Product;
import Entity.ProductPK;
import Entity.Warehouse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        
        
        
    }
}
