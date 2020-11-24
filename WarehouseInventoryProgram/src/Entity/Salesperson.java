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
@Table(name = "SALESPERSON")
@NamedQueries({
    @NamedQuery(name = "Salesperson.findAll", query = "SELECT s FROM Salesperson s"),
    @NamedQuery(name = "Salesperson.findByFristname", query = "SELECT s FROM Salesperson s WHERE s.fristname = :fristname"),
    @NamedQuery(name = "Salesperson.findByLastname", query = "SELECT s FROM Salesperson s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Salesperson.findByPhone", query = "SELECT s FROM Salesperson s WHERE s.phone = :phone"),
    @NamedQuery(name = "Salesperson.findByEmail", query = "SELECT s FROM Salesperson s WHERE s.email = :email"),
    @NamedQuery(name = "Salesperson.findByAddress", query = "SELECT s FROM Salesperson s WHERE s.address = :address"),
    @NamedQuery(name = "Salesperson.findByCity", query = "SELECT s FROM Salesperson s WHERE s.city = :city"),
    @NamedQuery(name = "Salesperson.findByState", query = "SELECT s FROM Salesperson s WHERE s.state = :state"),
    @NamedQuery(name = "Salesperson.findByZip", query = "SELECT s FROM Salesperson s WHERE s.zip = :zip"),
    @NamedQuery(name = "Salesperson.findByCommissionrate", query = "SELECT s FROM Salesperson s WHERE s.commissionrate = :commissionrate"),
    @NamedQuery(name = "Salesperson.findByTotalsales", query = "SELECT s FROM Salesperson s WHERE s.totalsales = :totalsales"),
    @NamedQuery(name = "Salesperson.findByTotalcommission", query = "SELECT s FROM Salesperson s WHERE s.totalcommission = :totalcommission"),
    @NamedQuery(name = "Salesperson.findBySalespersonid", query = "SELECT s FROM Salesperson s WHERE s.salespersonid = :salespersonid")})
public class Salesperson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "FRISTNAME")
    private String fristname;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @Column(name = "ZIP")
    private int zip;
    @Basic(optional = false)
    @Column(name = "COMMISSIONRATE")
    private double commissionrate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALSALES")
    private Double totalsales;
    @Column(name = "TOTALCOMMISSION")
    private Double totalcommission;
    @Id
    @Basic(optional = false)
    @Column(name = "SALESPERSONID")
    private Integer salespersonid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salespersonid")
    private Collection<Invoice> invoiceCollection;

    public Salesperson() {
    }

    public Salesperson(Integer salespersonid) {
        this.salespersonid = salespersonid;
    }

    public Salesperson(Integer salespersonid, String fristname, String lastname, String phone, String email, String address, String city, String state, int zip, double commissionrate) {
        this.salespersonid = salespersonid;
        this.fristname = fristname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.commissionrate = commissionrate;
    }

    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public double getCommissionrate() {
        return commissionrate;
    }

    public void setCommissionrate(double commissionrate) {
        this.commissionrate = commissionrate;
    }

    public Double getTotalsales() {
        return totalsales;
    }

    public void setTotalsales(Double totalsales) {
        this.totalsales = totalsales;
    }

    public Double getTotalcommission() {
        return totalcommission;
    }

    public void setTotalcommission(Double totalcommission) {
        this.totalcommission = totalcommission;
    }

    public Integer getSalespersonid() {
        return salespersonid;
    }

    public void setSalespersonid(Integer salespersonid) {
        this.salespersonid = salespersonid;
    }

    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salespersonid != null ? salespersonid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesperson)) {
            return false;
        }
        Salesperson other = (Salesperson) object;
        if ((this.salespersonid == null && other.salespersonid != null) || (this.salespersonid != null && !this.salespersonid.equals(other.salespersonid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Salesperson[ salespersonid=" + salespersonid + " ]";
    }
    
}