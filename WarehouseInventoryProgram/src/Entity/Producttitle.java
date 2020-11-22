/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author zubin
 */
@Entity
@Table(name = "PRODUCTTITLE")
@NamedQueries({
    @NamedQuery(name = "Producttitle.findAll", query = "SELECT p FROM Producttitle p"),
    @NamedQuery(name = "Producttitle.findByProductname", query = "SELECT p FROM Producttitle p WHERE p.productname = :productname"),
    @NamedQuery(name = "Producttitle.findBySellingprice", query = "SELECT p FROM Producttitle p WHERE p.sellingprice = :sellingprice"),
    @NamedQuery(name = "Producttitle.findByCostprice", query = "SELECT p FROM Producttitle p WHERE p.costprice = :costprice")})
public class Producttitle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Basic(optional = false)
    @Column(name = "SELLINGPRICE")
    private double sellingprice;
    @Basic(optional = false)
    @Column(name = "COSTPRICE")
    private int costprice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producttitle")
    private Collection<Product> productCollection;

    public Producttitle() {
    }

    public Producttitle(String productname) {
        this.productname = productname;
    }

    public Producttitle(String productname, double sellingprice, int costprice) {
        this.productname = productname;
        this.sellingprice = sellingprice;
        this.costprice = costprice;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(double sellingprice) {
        this.sellingprice = sellingprice;
    }

    public int getCostprice() {
        return costprice;
    }

    public void setCostprice(int costprice) {
        this.costprice = costprice;
    }

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productname != null ? productname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producttitle)) {
            return false;
        }
        Producttitle other = (Producttitle) object;
        if ((this.productname == null && other.productname != null) || (this.productname != null && !this.productname.equals(other.productname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Producttitle[ productname=" + productname + " ]";
    }
    
}
