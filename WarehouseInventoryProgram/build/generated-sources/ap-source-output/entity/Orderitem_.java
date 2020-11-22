package entity;

import entity.Invoice;
import entity.OrderitemPK;
import entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-11-20T09:21:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Orderitem.class)
public class Orderitem_ { 

    public static volatile SingularAttribute<Orderitem, Product> product;
    public static volatile SingularAttribute<Orderitem, Integer> quantity;
    public static volatile SingularAttribute<Orderitem, OrderitemPK> orderitemPK;
    public static volatile SingularAttribute<Orderitem, Invoice> invoice;

}