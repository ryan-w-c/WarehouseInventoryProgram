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
@Table(name = "INVOICE")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceid", query = "SELECT i FROM Invoice i WHERE i.invoiceid = :invoiceid"),
    @NamedQuery(name = "Invoice.findBySubtotal", query = "SELECT i FROM Invoice i WHERE i.subtotal = :subtotal"),
    @NamedQuery(name = "Invoice.findByTax", query = "SELECT i FROM Invoice i WHERE i.tax = :tax"),
    @NamedQuery(name = "Invoice.findByCommission", query = "SELECT i FROM Invoice i WHERE i.commission = :commission"),
    @NamedQuery(name = "Invoice.findByDeliverfee", query = "SELECT i FROM Invoice i WHERE i.deliverfee = :deliverfee"),
    @NamedQuery(name = "Invoice.findByTotal", query = "SELECT i FROM Invoice i WHERE i.total = :total"),
    @NamedQuery(name = "Invoice.findByBalanceremaining", query = "SELECT i FROM Invoice i WHERE i.balanceremaining = :balanceremaining"),
    @NamedQuery(name = "Invoice.findByOpenclose", query = "SELECT i FROM Invoice i WHERE i.openclose = :openclose"),
    @NamedQuery(name = "Invoice.findByDatetime", query = "SELECT i FROM Invoice i WHERE i.datetime = :datetime")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INVOICEID")
    private Integer invoiceid;
    @Basic(optional = false)
    @Column(name = "SUBTOTAL")
    private double subtotal;
    @Basic(optional = false)
    @Column(name = "TAX")
    private double tax;
    @Basic(optional = false)
    @Column(name = "COMMISSION")
    private double commission;
    @Basic(optional = false)
    @Column(name = "DELIVERFEE")
    private double deliverfee;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private double total;
    @Basic(optional = false)
    @Column(name = "BALANCEREMAINING")
    private double balanceremaining;
    @Basic(optional = false)
    @Column(name = "OPENCLOSE")
    private Boolean openclose;
    @Basic(optional = false)
    @Column(name = "DATETIME")
    private String datetime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private Collection<Orderitem> orderitemCollection;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private Customer customerid;
    @JoinColumn(name = "SALESPERSONID", referencedColumnName = "SALESPERSONID")
    @ManyToOne(optional = false)
    private Salesperson salespersonid;

    public Invoice() {
    }

    public Invoice(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Invoice(Integer invoiceid, double subtotal, double tax, double commission, double deliverfee, double total, double balanceremaining, Boolean openclose, String datetime) {
        this.invoiceid = invoiceid;
        this.subtotal = subtotal;
        this.tax = tax;
        this.commission = commission;
        this.deliverfee = deliverfee;
        this.total = total;
        this.balanceremaining = balanceremaining;
        this.openclose = openclose;
        this.datetime = datetime;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getDeliverfee() {
        return deliverfee;
    }

    public void setDeliverfee(double deliverfee) {
        this.deliverfee = deliverfee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBalanceremaining() {
        return balanceremaining;
    }

    public void setBalanceremaining(double balanceremaining) {
        this.balanceremaining = balanceremaining;
    }
    
    public void updateBalanceRemaining(double amount) {
        balanceremaining -= amount;
        if (balanceremaining <= 0) {
            balanceremaining = 0;
            setOpenclose(false);
        }
            
    }

    public Boolean getOpenclose() {
        return openclose;
    }

    public void setOpenclose(Boolean openclose) {
        this.openclose = openclose;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Collection<Orderitem> getOrderitemCollection() {
        return orderitemCollection;
    }

    public void setOrderitemCollection(Collection<Orderitem> orderitemCollection) {
        this.orderitemCollection = orderitemCollection;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Salesperson getSalespersonid() {
        return salespersonid;
    }

    public void setSalespersonid(Salesperson salespersonid) {
        this.salespersonid = salespersonid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceid != null ? invoiceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceid == null && other.invoiceid != null) || (this.invoiceid != null && !this.invoiceid.equals(other.invoiceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Invoice[ invoiceid=" + invoiceid + " ]";
    }
    
}
