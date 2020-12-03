/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ryancavanagh
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productPK.productname = :productname"),
    @NamedQuery(name = "Product.findByPK", query = "SELECT p FROM Product p WHERE p.productPK.productname = :productname and p.productPK.warehousename = :warehousename"),
    @NamedQuery(name = "Product.findByWarehousename", query = "SELECT p FROM Product p WHERE p.productPK.warehousename = :warehousename"),
    @NamedQuery(name = "Product.findByWarehousenameLow", query = "SELECT p FROM Product p WHERE p.productPK.warehousename = :warehousename and p.quantity < 6"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findBySellingprice", query = "SELECT p FROM Product p WHERE p.sellingprice = :sellingprice"),
    @NamedQuery(name = "Product.findByCostprice", query = "SELECT p FROM Product p WHERE p.costprice = :costprice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductPK productPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SELLINGPRICE")
    private double sellingprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTPRICE")
    private double costprice;
    @JoinColumn(name = "WAREHOUSENAME", referencedColumnName = "WAREHOUSENAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouse;

    public Product() {
    }

    public Product(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Product(ProductPK productPK, int quantity, double sellingprice, double costprice) {
        this.productPK = productPK;
        this.quantity = quantity;
        this.sellingprice = sellingprice;
        this.costprice = costprice;
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
    
    public void updateQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public double getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(double sellingprice) {
        this.sellingprice = sellingprice;
    }

    public double getCostprice() {
        return costprice;
    }

    public void setCostprice(double costprice) {
        this.costprice = costprice;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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
