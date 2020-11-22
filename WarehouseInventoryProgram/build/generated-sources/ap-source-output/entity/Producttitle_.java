package entity;

import entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-11-20T09:21:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Producttitle.class)
public class Producttitle_ { 

    public static volatile CollectionAttribute<Producttitle, Product> productCollection;
    public static volatile SingularAttribute<Producttitle, Double> sellingprice;
    public static volatile SingularAttribute<Producttitle, String> productname;
    public static volatile SingularAttribute<Producttitle, Integer> costprice;

}