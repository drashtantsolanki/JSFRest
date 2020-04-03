/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tbldepartment;
import entity.Tblemployee;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hi
 */
@Stateless
public class employeeBean implements employeeBeanLocal {

    @PersistenceContext(unitName = "MyPU")
    EntityManager em;
    
    
    @Override
    public Collection<Tblemployee> getAllEmployees() {
        return em.createNamedQuery("Tblemployee.findAll").getResultList();
    }

    @Override
    public Tblemployee getEmployee(int id) {
        return em.find(Tblemployee.class, id);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addEmployee(String name, int salary, int deptId) {
        Tblemployee e=new Tblemployee();
        e.setName(name);
        e.setSalary(salary);
        
        Tbldepartment d=em.find(Tbldepartment.class, deptId);
        Collection<Tblemployee> emplst=d.getTblemployeeCollection();
        e.setDeptId(d);
        emplst.add(e);
        
        em.merge(d);
        em.persist(e);
    }

    @Override
    public void deleteEmployee(int id) {
        Tblemployee e=em.find(Tblemployee.class, id);
        em.remove(e);
    }

    @Override
    public void updateEmployee(int id, String name, int salary, int deptId) {
        Tblemployee e=em.find(Tblemployee.class, id);
        Tbldepartment d=em.find(Tbldepartment.class, deptId);
        e.setId(id);
        e.setName(name);
        Collection<Tblemployee> emplst=d.getTblemployeeCollection();
        e.setDeptId(d);
        emplst.add(e);
        
        em.merge(d);
        em.merge(e);
    }
}
