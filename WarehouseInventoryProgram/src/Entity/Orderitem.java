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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author zubin
 */
@Entity
@Table(name = "ORDERITEM")
@NamedQueries({
    @NamedQuery(name = "Orderitem.findAll", query = "SELECT o FROM Orderitem o"),
    @NamedQuery(name = "Orderitem.findByPK", query = "SELECT o FROM Orderitem o WHERE o.orderitemPK.invoiceid = :invoiceid and o.orderitemPK.productname = :productname and o.orderitemPK.warehousename = :warehousename"),
    @NamedQuery(name = "Orderitem.findByInvoiceid", query = "SELECT o FROM Orderitem o WHERE o.orderitemPK.invoiceid = :invoiceid"),
    @NamedQuery(name = "Orderitem.findByProductname", query = "SELECT o FROM Orderitem o WHERE o.orderitemPK.productname = :productname"),
    @NamedQuery(name = "Orderitem.findByWarehousename", query = "SELECT o FROM Orderitem o WHERE o.orderitemPK.warehousename = :warehousename"),
    @NamedQuery(name = "Orderitem.findByQuantity", query = "SELECT o FROM Orderitem o WHERE o.quantity = :quantity")})
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderitemPK orderitemPK;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;
    @JoinColumn(name = "INVOICEID", referencedColumnName = "INVOICEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invoice invoice;
    @JoinColumns({
        @JoinColumn(name = "PRODUCTNAME", referencedColumnName = "PRODUCTNAME", insertable = false, updatable = false),
        @JoinColumn(name = "WAREHOUSENAME", referencedColumnName = "WAREHOUSENAME", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Product product;

    public Orderitem() {
    }

    public Orderitem(OrderitemPK orderitemPK) {
        this.orderitemPK = orderitemPK;
    }

    public Orderitem(OrderitemPK orderitemPK, int quantity) {
        this.orderitemPK = orderitemPK;
        this.quantity = quantity;
    }

    public Orderitem(int invoiceid, String productname, String warehousename) {
        this.orderitemPK = new OrderitemPK(invoiceid, productname, warehousename);
    }
    
    public Orderitem(int invoiceid, String productname, String warehousename, int quantity) {
        this.orderitemPK = new OrderitemPK(invoiceid, productname, warehousename);
        this.quantity = quantity;
    }

    public OrderitemPK getOrderitemPK() {
        return orderitemPK;
    }

    public void setOrderitemPK(OrderitemPK orderitemPK) {
        this.orderitemPK = orderitemPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderitemPK != null ? orderitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderitem)) {
            return false;
        }
        Orderitem other = (Orderitem) object;
        if ((this.orderitemPK == null && other.orderitemPK != null) || (this.orderitemPK != null && !this.orderitemPK.equals(other.orderitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orderitem[ orderitemPK=" + orderitemPK + " ]";
    }
    
}
