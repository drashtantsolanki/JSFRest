/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblemployee;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author hi
 */
@Local
public interface employeeBeanLocal {
    Collection<Tblemployee> getAllEmployees();
    void addEmployee(String name,int salary,int deptId);
    void deleteEmployee(int id);
    void updateEmployee(int id,String name,int salary,int deptId);
    Tblemployee getEmployee(int id);
}
