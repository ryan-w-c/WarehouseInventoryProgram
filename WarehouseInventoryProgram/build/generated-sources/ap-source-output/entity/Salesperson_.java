package entity;

import entity.Invoice;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-11-20T09:21:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Salesperson.class)
public class Salesperson_ { 

    public static volatile SingularAttribute<Salesperson, Integer> zip;
    public static volatile SingularAttribute<Salesperson, String> fristname;
    public static volatile SingularAttribute<Salesperson, String> address;
    public static volatile SingularAttribute<Salesperson, String> city;
    public static volatile SingularAttribute<Salesperson, Double> totalsales;
    public static volatile SingularAttribute<Salesperson, String> lastname;
    public static volatile CollectionAttribute<Salesperson, Invoice> invoiceCollection;
    public static volatile SingularAttribute<Salesperson, Double> commissionrate;
    public static volatile SingularAttribute<Salesperson, Integer> salespersonid;
    public static volatile SingularAttribute<Salesperson, String> phone;
    public static volatile SingularAttribute<Salesperson, String> state;
    public static volatile SingularAttribute<Salesperson, Double> totalcommission;
    public static volatile SingularAttribute<Salesperson, String> email;

}