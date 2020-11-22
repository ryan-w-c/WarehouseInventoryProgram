package entity;

import entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-11-20T09:21:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Warehouse.class)
public class Warehouse_ { 

    public static volatile SingularAttribute<Warehouse, Integer> zipcode;
    public static volatile SingularAttribute<Warehouse, String> address;
    public static volatile CollectionAttribute<Warehouse, Product> productCollection;
    public static volatile SingularAttribute<Warehouse, String> phone;
    public static volatile SingularAttribute<Warehouse, String> city;
    public static volatile SingularAttribute<Warehouse, String> state;
    public static volatile SingularAttribute<Warehouse, String> warehousename;

}