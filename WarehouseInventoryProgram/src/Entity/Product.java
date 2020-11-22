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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author zubin
 */
@Entity
@Table(name = "PRODUCT")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productPK.productname = :productname"),
    @NamedQuery(name = "Product.findByWarehousename", query = "SELECT p FROM Product p WHERE p.productPK.warehousename = :warehousename"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductPK productPK;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;
    @JoinColumn(name = "PRODUCTNAME", referencedColumnName = "PRODUCTNAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producttitle producttitle;
    @JoinColumn(name = "WAREHOUSENAME", referencedColumnName = "WAREHOUSENAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<Orderitem> orderitemCollection;

    public Product() {
    }

    public Product(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Product(ProductPK productPK, int quantity) {
        this.productPK = productPK;
        this.quantity = quantity;
    }

    public Product(String productname, String warehousename) {
        this.productPK = new ProductPK(productname, warehousename);
    }

    public ProductPK getProductPK() {
        return productPK;
    }

    public void setProductPK(ProductPK productPK) {
        this.productPK = productPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Producttitle getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(Producttitle producttitle) {
        this.producttitle = producttitle;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Collection<Orderitem> getOrderitemCollection() {
        return orderitemCollection;
    }

    public void setOrderitemCollection(Collection<Orderitem> orderitemCollection) {
        this.orderitemCollection = orderitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPK != null ? productPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productPK == null && other.productPK != null) || (this.productPK != null && !this.productPK.equals(other.productPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Product[ productPK=" + productPK + " ]";
    }
    
}
