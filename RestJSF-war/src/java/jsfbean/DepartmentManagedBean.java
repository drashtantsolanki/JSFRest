/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfbean;

import entity.Tbldepartment;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import jerseyclient.DepartmentJerseyClient;

/**
 *
 * @author hi
 */
@Named(value = "departmentManagedBean")
@RequestScoped
public class DepartmentManagedBean {

    /**
     * Creates a new instance of DepartmentManagedBean
     */
    int did;
    String departmentName;
    DepartmentJerseyClient djc=new DepartmentJerseyClient();
    
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    
    public Collection<Tbldepartment> getAllDepartment()
    {
        Response response=djc.getAllDepartment(Response.class);
        ArrayList<Tbldepartment> dlist= new ArrayList<>();
        GenericType<Collection<Tbldepartment>> gdept=new GenericType<Collection<Tbldepartment>>(){};
        dlist=(ArrayList<Tbldepartment>) response.readEntity(gdept);
        return dlist;
    }
    
    public String addDepartment()
    {
        
        if(did!=0)
        {
            Tbldepartment d = new Tbldepartment();
            d.setDeptId(did);
            d.setDepartmentName(departmentName);
            djc.updateDepartment(d);
        }
        else
        {
        
            Tbldepartment d = new Tbldepartment();
            //d.setDeptId(did);
            d.setDepartmentName(departmentName);
            djc.addDepartment(d);            
        }
        return "departmentHome.xhtml";
    }
    
    public String getDepartment(String did)
    {
        Response response=djc.getDepartment(Response.class, did);
        GenericType<Tbldepartment> gdept=new GenericType<Tbldepartment>(){};
        Tbldepartment d=response.readEntity(gdept);
        this.did=d.getDeptId();
        this.departmentName=d.getDepartmentName();
        return "addDepartment.xhtml";
        
    }
    
    public void deleteDepartment()
    {
        djc.deleteDepartment(did+"");
    }
    
    public DepartmentManagedBean() {
    }
    
}
