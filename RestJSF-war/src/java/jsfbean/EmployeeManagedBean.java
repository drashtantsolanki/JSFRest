/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfbean;

import ejb.departmentBeanLocal;
import entity.Tbldepartment;
import entity.Tblemployee;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import jerseyclient.EmployeeJerseyClient;

/**
 *
 * @author hi
 */
@Named(value = "employeeManagedBean")
@RequestScoped
public class EmployeeManagedBean {

    /**
     * Creates a new instance of EmployeeManagedBean
     */
    
    int eid,salary,did;
    String ename;
    Collection<Tbldepartment> dlist;
    
    @EJB departmentBeanLocal dbl;
    
    EmployeeJerseyClient ejc=new EmployeeJerseyClient();

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
    
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Collection<Tbldepartment> getDlist() {
        return dlist;
    }

    public void setDlist(Collection<Tbldepartment> dlist) {
        this.dlist = dlist;
    }
    
    public Collection<Tblemployee> getAllEmployees()
    {
        Response response=ejc.getAllEmployees(Response.class);
        ArrayList<Tblemployee> elist=new ArrayList<Tblemployee>();
        GenericType<ArrayList<Tblemployee>> gemp=new GenericType<ArrayList<Tblemployee>>(){};
        elist=(ArrayList<Tblemployee>)response.readEntity(gemp);
        return elist;
    }
    
    public String getEmployee(String id)
    {
        Response response =ejc.getEmployee(Response.class, id);
        GenericType<Tblemployee> gemp=new GenericType<Tblemployee>(){};
        Tblemployee e=response.readEntity(gemp);
        eid=e.getId();
        ename=e.getName();
        salary=e.getSalary();
        did=e.getDeptId().getDeptId();
        
        return "addemployee.xhtml";
    }
    
    public String addEmployee()
    {
        if(eid!=0)
        {
            Tblemployee e=new Tblemployee();
            e.setId(eid);
            e.setName(ename);
            e.setSalary(salary);
            e.setDeptId(new Tbldepartment(did));
            ejc.updateEmployee(e);
        }
        else
        {
            Tblemployee e=new Tblemployee();
            e.setName(ename);
            e.setSalary(salary);
            e.setDeptId(new Tbldepartment(did));
            ejc.addEmployee(e);
        }
        return "home.xhtml";
    }
    
    public String deleteEmployee(String eid)
    {
        ejc.deleteEmployee(eid);
        return "home.xhtml";
    }
    
    
    @PostConstruct
    public  void init()
    {
        dlist=dbl.getAllDepartment();
    }
    
    public EmployeeManagedBean() {
    }
    
}
