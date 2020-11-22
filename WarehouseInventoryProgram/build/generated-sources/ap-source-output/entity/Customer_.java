package entity;

import entity.Invoice;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-11-20T09:21:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Integer> zip;
    public static volatile CollectionAttribute<Customer, Invoice> invoiceCollection;
    public static volatile SingularAttribute<Customer, String> firstname;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, String> city;
    public static volatile SingularAttribute<Customer, Integer> customerid;
    public static volatile SingularAttribute<Customer, String> state;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, String> lastname;

}