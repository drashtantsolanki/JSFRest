/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.departmentBeanLocal;
import entity.Tbldepartment;
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
@Path("department")
public class DepartmentResource {

    @EJB departmentBeanLocal dbl;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DepartmentResource
     */
    public DepartmentResource() {
    }

    /**
     * Retrieves representation of an instance of rest.DepartmentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tbldepartment> getAllDepartment() {
       return dbl.getAllDepartment();
    }
    
    @GET
    @Path("getDepartment/{did}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tbldepartment getDepartment(@PathParam("did") int did)
    {
        return dbl.getDepartment(did);
    }
    
    @POST
    @Path("addDepartment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDepartment(Tbldepartment objDepartment)
    {
        dbl.addDepartment(objDepartment.getDepartmentName());
    }
    
    @POST
    @Path("updateDepartment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDepartment(Tbldepartment objDepartment)
    {
        dbl.updateDepartment(objDepartment.getDeptId(),objDepartment.getDepartmentName());
    }
    
    @DELETE
    @Path("deleteDepartment/{did}")
    public void deleteDepartment(@PathParam("did") int id)
    {
        dbl.deleteDepartment(id);
    }

    /**
     * PUT method for updating or creating an instance of DepartmentResource
     * @param content representation for the resource
     */
    
}
