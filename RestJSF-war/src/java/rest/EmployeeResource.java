/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.departmentBeanLocal;
import ejb.employeeBeanLocal;
import entity.Tblemployee;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hi
 */
@Path("employee")
public class EmployeeResource {

    @EJB employeeBeanLocal ebl;
    
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeeResource
     */
    public EmployeeResource() {
    }

    /**
     * Retrieves representation of an instance of rest.EmployeeResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblemployee> getAllEmployees() {
        return ebl.getAllEmployees();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getEmployee/{eid}")
    public Tblemployee getEmployee(@PathParam("eid") int id)
    {
        return ebl.getEmployee(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addEmployee")
    public void addEmployee(Tblemployee emp)
    {
        ebl.addEmployee(emp.getName(), emp.getSalary(), emp.getDeptId().getDeptId());
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("updateEmployee")
    public void updateEmployee(Tblemployee emp)
    {
        ebl.updateEmployee(emp.getId(),emp.getName(), emp.getSalary(), emp.getDeptId().getDeptId());
    }
    
    @DELETE
    @Path("deleteEmployee/{eid}")
    public void deleteEmployee(@PathParam("eid") int eid)
    {
        ebl.deleteEmployee(eid);
    }
    
}
