package entity;

import entity.Orderitem;
import entity.ProductPK;
import entity.Producttitle;
import entity.Warehouse;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-11-20T09:21:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile SingularAttribute<Product, ProductPK> productPK;
    public static volatile SingularAttribute<Product, Producttitle> producttitle;
    public static volatile CollectionAttribute<Product, Orderitem> orderitemCollection;
    public static volatile SingularAttribute<Product, Warehouse> warehouse;

}