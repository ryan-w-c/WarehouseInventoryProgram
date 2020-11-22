/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author zubin
 */
@Embeddable
public class OrderitemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "INVOICEID")
    private int invoiceid;
    @Basic(optional = false)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Basic(optional = false)
    @Column(name = "WAREHOUSENAME")
    private String warehousename;

    public OrderitemPK() {
    }

    public OrderitemPK(int invoiceid, String productname, String warehousename) {
        this.invoiceid = invoiceid;
        this.productname = productname;
        this.warehousename = warehousename;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getWarehousename() {
        return warehousename;
    }

    public void setWarehousename(String warehousename) {
        this.warehousename = warehousename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) invoiceid;
        hash += (productname != null ? productname.hashCode() : 0);
        hash += (warehousename != null ? warehousename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderitemPK)) {
            return false;
        }
        OrderitemPK other = (OrderitemPK) object;
        if (this.invoiceid != other.invoiceid) {
            return false;
        }
        if ((this.productname == null && other.productname != null) || (this.productname != null && !this.productname.equals(other.productname))) {
            return false;
        }
        if ((this.warehousename == null && other.warehousename != null) || (this.warehousename != null && !this.warehousename.equals(other.warehousename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderitemPK[ invoiceid=" + invoiceid + ", productname=" + productname + ", warehousename=" + warehousename + " ]";
    }
    
}
