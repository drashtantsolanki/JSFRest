/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tbldepartment;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author hi
 */
@Local
public interface departmentBeanLocal {
    Collection<Tbldepartment> getAllDepartment();
    Tbldepartment getDepartment(int id);
    void addDepartment(String name);
    void deleteDepartment(int id);
    void updateDepartment(int id,String name);
}
