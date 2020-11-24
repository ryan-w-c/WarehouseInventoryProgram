/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ryancavanagh
 */
@Entity
@Table(name = "SALESPERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesperson.findAll", query = "SELECT s FROM Salesperson s"),
    @NamedQuery(name = "Salesperson.findByFirstname", query = "SELECT s FROM Salesperson s WHERE s.firstname = :firstname"),
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
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIP")
    private int zip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMMISSIONRATE")
    private double commissionrate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALSALES")
    private Double totalsales;
    @Column(name = "TOTALCOMMISSION")
    private Double totalcommission;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALESPERSONID")
    private Integer salespersonid;

    public Salesperson() {
    }

    public Salesperson(Integer salespersonid) {
        this.salespersonid = salespersonid;
    }

    public Salesperson(Integer salespersonid, String firstname, String lastname, String phone, String email, String address, String city, String state, int zip, double commissionrate) {
        this.salespersonid = salespersonid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.commissionrate = commissionrate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
