/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tbldepartment;
import entity.Tblemployee_;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hi
 */
@Stateless
public class departmentBean implements departmentBeanLocal {

    @PersistenceContext(unitName = "MyPU")
    EntityManager em;
    
    
    @Override
    public Collection<Tbldepartment> getAllDepartment() {
        return em.createNamedQuery("Tbldepartment.findAll").getResultList();
    }

    @Override
    public Tbldepartment getDepartment(int id) {
        return em.find(Tbldepartment.class, id);
    }

    @Override
    public void addDepartment(String name) {
        Tbldepartment d=new Tbldepartment();
        d.setDepartmentName(name);
        em.persist(d);
    }

    @Override
    public void deleteDepartment(int id) {
        Tbldepartment d=em.find(Tbldepartment.class, id);
        em.remove(d);
    }

    @Override
    public void updateDepartment(int id, String name) {
        Tbldepartment d=em.find(Tbldepartment.class, id);
        d.setDeptId(id);
        d.setDepartmentName(name);
        em.merge(d);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
