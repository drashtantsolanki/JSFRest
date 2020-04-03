/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hi
 */
@Entity
@Table(name = "tbldepartment")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbldepartment.findAll", query = "SELECT t FROM Tbldepartment t"),
    @NamedQuery(name = "Tbldepartment.findByDeptId", query = "SELECT t FROM Tbldepartment t WHERE t.deptId = :deptId"),
    @NamedQuery(name = "Tbldepartment.findByDepartmentName", query = "SELECT t FROM Tbldepartment t WHERE t.departmentName = :departmentName")})
public class Tbldepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DeptId")
    private Integer deptId;
    @Basic(optional = false)
    @Column(name = "DepartmentName")
    private String departmentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
    private Collection<Tblemployee> tblemployeeCollection;

    public Tbldepartment() {
    }

    public Tbldepartment(Integer deptId) {
        this.deptId = deptId;
    }

    public Tbldepartment(Integer deptId, String departmentName) {
        this.deptId = deptId;
        this.departmentName = departmentName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    //@XmlTransient
    @JsonbTransient
    public Collection<Tblemployee> getTblemployeeCollection() {
        return tblemployeeCollection;
    }

    public void setTblemployeeCollection(Collection<Tblemployee> tblemployeeCollection) {
        this.tblemployeeCollection = tblemployeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbldepartment)) {
            return false;
        }
        Tbldepartment other = (Tbldepartment) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbldepartment[ deptId=" + deptId + " ]";
    }
    
}
