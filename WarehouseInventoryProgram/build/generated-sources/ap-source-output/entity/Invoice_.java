package entity;

import entity.Customer;
import entity.Orderitem;
import entity.Salesperson;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-11-20T09:21:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, Double> total;
    public static volatile SingularAttribute<Invoice, String> datetime;
    public static volatile SingularAttribute<Invoice, Double> balanceremaining;
    public static volatile SingularAttribute<Invoice, Salesperson> salespersonid;
    public static volatile SingularAttribute<Invoice, Double> subtotal;
    public static volatile CollectionAttribute<Invoice, Orderitem> orderitemCollection;
    public static volatile SingularAttribute<Invoice, Customer> customerid;
    public static volatile SingularAttribute<Invoice, Double> tax;
    public static volatile SingularAttribute<Invoice, Integer> invoiceid;
    public static volatile SingularAttribute<Invoice, Double> commission;
    public static volatile SingularAttribute<Invoice, Double> deliverfee;
    public static volatile SingularAttribute<Invoice, Boolean> openclose;

}