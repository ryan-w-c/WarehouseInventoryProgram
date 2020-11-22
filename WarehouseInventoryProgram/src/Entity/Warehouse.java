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
@Table(name = "WAREHOUSE")
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByWarehousename", query = "SELECT w FROM Warehouse w WHERE w.warehousename = :warehousename"),
    @NamedQuery(name = "Warehouse.findByPhone", query = "SELECT w FROM Warehouse w WHERE w.phone = :phone"),
    @NamedQuery(name = "Warehouse.findByAddress", query = "SELECT w FROM Warehouse w WHERE w.address = :address"),
    @NamedQuery(name = "Warehouse.findByCity", query = "SELECT w FROM Warehouse w WHERE w.city = :city"),
    @NamedQuery(name = "Warehouse.findByState", query = "SELECT w FROM Warehouse w WHERE w.state = :state"),
    @NamedQuery(name = "Warehouse.findByZipcode", query = "SELECT w FROM Warehouse w WHERE w.zipcode = :zipcode")})
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WAREHOUSENAME")
    private String warehousename;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
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
    @Column(name = "ZIPCODE")
    private int zipcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouse")
    private Collection<Product> productCollection;

    public Warehouse() {
    }

    public Warehouse(String warehousename) {
        this.warehousename = warehousename;
    }

    public Warehouse(String warehousename, String phone, String address, String city, String state, int zipcode) {
        this.warehousename = warehousename;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getWarehousename() {
        return warehousename;
    }

    public void setWarehousename(String warehousename) {
        this.warehousename = warehousename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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
        hash += (warehousename != null ? warehousename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.warehousename == null && other.warehousename != null) || (this.warehousename != null && !this.warehousename.equals(other.warehousename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Warehouse[ warehousename=" + warehousename + " ]";
    }
    
}
